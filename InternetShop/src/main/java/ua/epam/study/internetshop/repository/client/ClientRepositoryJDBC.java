/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.study.internetshop.repository.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.epam.study.internetshop.domain.client.Client;
import ua.epam.study.internetshop.domain.goods.Goods;

/**
 *
 * @author Artem_Kobeliev
 */
public class ClientRepositoryJDBC implements ClientRepository{
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    
    public ClientRepositoryJDBC(){}
    
    public ClientRepositoryJDBC(DataSource ds){
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
    public Client find(Integer id) {
        return jdbcTemplate.queryForObject("select * from Client where id=?", new Object[]{id}, 
                 new RowMapper<Client>() {
                    @Override
                    public Client mapRow(ResultSet rs, int i) throws SQLException {
                         return map(rs);
                    }
                 }
              );
    }
    
    @Override
    public List<?> findAll() {
        return jdbcTemplate.query("select * from Client", 
                 new RowMapper<Client>() {
                    @Override
                    public Client mapRow(ResultSet rs, int i) throws SQLException {
                         return map(rs);
                    }
                 }
              );
    }
    
    @Override
    public boolean create(Client client) {
        if (jdbcTemplate == null) return false;
        jdbcTemplate.update("INSERT INTO Client "
                    + "(name, discount) VALUES (?, ?)",new Object[]
                    {client.getClientName(), client.getClientDiscount()});
        return true;
    }
    
    @Override
    public Client findByName(String clientName) {
        return jdbcTemplate.queryForObject("select * from Client where name=?", new Object[]{clientName}, 
                 new RowMapper<Client>() {
                    @Override
                    public Client mapRow(ResultSet rs, int i) throws SQLException {
                         return map(rs);
                    }
                 }
              );
    }
    
    private Client map(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setClientID(resultSet.getInt(1));
        client.setClientName(resultSet.getString(2));
        client.setClientDiscount(resultSet.getInt(3));
        return client;
    }
    
}
