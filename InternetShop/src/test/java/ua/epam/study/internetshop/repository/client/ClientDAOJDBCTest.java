/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.study.internetshop.repository.client;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ua.epam.study.internetshop.domain.client.Client;
import ua.epam.study.internetshop.domain.goods.Goods;
import ua.epam.study.internetshop.repository.DAOTestsTemplate;
import ua.epam.study.internetshop.repository.bucket.BucketRepositoryJDBC;
import ua.epam.study.internetshop.repository.goods.GoodsRepositoryJDBC;

/**
 *
 * @author Artem_Kobeliev
 */
public class ClientDAOJDBCTest extends DAOTestsTemplate {
   
    //@Autowired
    private GoodsRepositoryJDBC goodsRepository = context.getBean("goodsRepository",
            ua.epam.study.internetshop.repository.goods.GoodsRepositoryJDBC.class);
    private BucketRepositoryJDBC bucketRepository = context.getBean("bucketRepository",
            ua.epam.study.internetshop.repository.bucket.BucketRepositoryJDBC.class);
    private ClientRepositoryJDBC clientRepository = context.getBean("clientRepository", 
            ua.epam.study.internetshop.repository.client.ClientRepositoryJDBC.class);

    //@Before
    @After
    public void clearDB() {
        System.out.println("clear my DB");
        jdbcTemplate.execute("TRUNCATE SCHEMA PUBLIC RESTART IDENTITY AND COMMIT");
        
    }
    
    @Test
    public void testCreateClientNoExceptions() {
        System.out.println("my Test 1");
        Client client = new Client("ABC", 1);
        clientRepository.create(client);
    }
    
    @Test
    public void testCreateClient() {
        System.out.println("Test 2");
        Client client = new Client("ABC", 1);
        clientRepository.create(client);

        int size = jdbcTemplate.queryForObject("select count(*) from Client", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByNameClient() {
        System.out.println("Test 3");
        Client client = new Client("ABC", 1);
        clientRepository.create(client);

        Client actualResult = clientRepository.findByName("ABC");
        Assert.assertEquals(client, actualResult);
    }

    @Test
    public void testFindAllClients() {
        System.out.println("Test 4");
        Client client1 = new Client("ABC", 1);
        Client client2 = new Client("BC", 2);
        clientRepository.create(client1);
        clientRepository.create(client2);

        List actualResult = clientRepository.findAll();
        for (Object g : actualResult) {
            System.out.println(g);
        }
        Assert.assertEquals(2, actualResult.size());
    }
    
    @Test
    public void testFind(){
        System.out.println("Test 5");
        Client client = new Client("ABC", 1);
        clientRepository.create(client);
        Client res = clientRepository.find(0);
        Assert.assertEquals(res, client);
    }
     
}
