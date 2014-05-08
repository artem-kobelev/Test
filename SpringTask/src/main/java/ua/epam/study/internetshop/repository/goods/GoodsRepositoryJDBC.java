/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.study.internetshop.repository.goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import ua.epam.study.internetshop.domain.goods.Goods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Artem_Kobeliev
 */
public class GoodsRepositoryJDBC implements GoodsRepository{
    
    //@Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    
    public GoodsRepositoryJDBC(){
    }
    
    public GoodsRepositoryJDBC(DataSource ds){
        this.dataSource = ds;
    }
    
    /*public GoodsRepositoryJDBC(DataSource ds, JdbcTemplate jdbcTemplate){
        this.dataSource = ds;
        this.jdbcTemplate = jdbcTemplate;
    }*/
    
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
    public Goods find(Integer id) {
        return jdbcTemplate.queryForObject("select * from Goods where id=?", new Object[]{id}, 
                 new RowMapper<Goods>() {
                    @Override
                    public Goods mapRow(ResultSet rs, int i) throws SQLException {
                         return map(rs);
                    }
                 }
              );
    }
    
    @Override
    public List<?> findAll() {
        return jdbcTemplate.query("select * from Goods", 
                 new RowMapper<Goods>() {
                    @Override
                    public Goods mapRow(ResultSet rs, int i) throws SQLException {
                         return map(rs);
                    }
                 }
              );
    }
    
    @Override
    public boolean create(Goods goods) {
        if (jdbcTemplate == null) return false;
        jdbcTemplate.update("INSERT INTO Goods "
                    + "(name, price) VALUES (?, ?)",new Object[]
                    {goods.getGoodsName(), goods.getGoodsPrice()});
        return true;
    }

    @Override
    public Goods findByName(String goodsName) {
        return jdbcTemplate.queryForObject("select * from Goods where name=?", new Object[]{goodsName}, 
                 new RowMapper<Goods>() {
                    @Override
                    public Goods mapRow(ResultSet rs, int i) throws SQLException {
                         return map(rs);
                    }
                 }
              );
    }
    
    private Goods map(ResultSet resultSet) throws SQLException {
        Goods goods = new Goods();
        goods.setGoodsID(resultSet.getInt(1));
        goods.setGoodsName(resultSet.getString(2));
        goods.setGoodsPrice(resultSet.getInt(3));
        return goods;
    }
    
}
