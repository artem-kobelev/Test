/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.study.internetshop.repository.bucket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.epam.study.internetshop.domain.bucket.Bucket;
import ua.epam.study.internetshop.domain.goods.Goods;

/**
 *
 * @author Artem_Kobeliev
 */
public class BucketRepositoryJDBC implements BucketRepository {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    
    public BucketRepositoryJDBC(){}
    
    public BucketRepositoryJDBC(DataSource ds){
        this.dataSource = ds;
    }
    
    public void setDataSource(DataSource ds){
        this.dataSource = ds;
    }
    
    public DataSource getDataSource(){
        return this.dataSource;
    }
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public JdbcTemplate getJdbcTemplate(){
        return this.jdbcTemplate;
    }
    
    @Override
    public Bucket find(Integer id) {
        return jdbcTemplate.queryForObject("select * from Bucket where id=?", new Object[]{id}, 
                 new RowMapper<Bucket>() {
                    @Override
                    public Bucket mapRow(ResultSet rs, int i) throws SQLException {
                         return map(rs);
                    }
                 }
              );
    }

    @Override
    public List<?> findAll() {
        return jdbcTemplate.query("select * from Bucket", 
                 new RowMapper<Bucket>() {
                    @Override
                    public Bucket mapRow(ResultSet rs, int i) throws SQLException {
                         return map(rs);
                    }
                 }
              );
    }

    @Override
    public boolean create(Bucket bucket) {
        if (jdbcTemplate == null) return false;
        jdbcTemplate.update("INSERT INTO Bucket "
                    + "(clietnID, goodsID) VALUES (?, ?)",new Object[]
                    {bucket.getBucketClientID(), bucket.getBucketGoodsID()});
        return true;
    }
    
    private Bucket map(ResultSet resultSet) throws SQLException {
        Bucket bucket = new Bucket();
        bucket.setBucketID(resultSet.getInt(1));
        bucket.setBucketClientID(resultSet.getInt(2));
        bucket.setBucketGoodsID(resultSet.getInt(3));
        return bucket;
    }
    
}
