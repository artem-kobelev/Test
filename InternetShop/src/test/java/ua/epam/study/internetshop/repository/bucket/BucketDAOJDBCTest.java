/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.study.internetshop.repository.bucket;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ua.epam.study.internetshop.domain.bucket.Bucket;
import ua.epam.study.internetshop.domain.client.Client;
import ua.epam.study.internetshop.domain.goods.Goods;
import ua.epam.study.internetshop.repository.DAOTestsTemplate;
import ua.epam.study.internetshop.repository.client.ClientRepositoryJDBC;
import ua.epam.study.internetshop.repository.goods.GoodsRepositoryJDBC;

/**
 *
 * @author Artem_Kobeliev
 */
public class BucketDAOJDBCTest extends DAOTestsTemplate {

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
    public void testCreateBucketNoExceptions() {
        System.out.println("my Test 1");
        Goods goods = new Goods("ABC", 1);
        goodsRepository.create(goods);
        Client client = new Client("client", 2);
        clientRepository.create(client);
        
        Bucket bucket = new Bucket(0, 0);
        bucketRepository.create(bucket);
    }
    
    @Test
    public void testCreateBucket() {
        System.out.println("Test 2");
        Goods goods = new Goods("ABC", 1);
        goodsRepository.create(goods);
        Client client = new Client("client", 2);
        clientRepository.create(client);
        
        Bucket bucket = new Bucket(0, 0);
        bucketRepository.create(bucket);

        int size = jdbcTemplate.queryForObject("select count(*) from Bucket", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindAllBucket() {
        System.out.println("Test 4");
        Goods goods1 = new Goods("ABC", 1);
        goodsRepository.create(goods1);
        Client client1 = new Client("client1", 2);
        clientRepository.create(client1);
        
        Bucket bucket1 = new Bucket(0, 0);
        bucketRepository.create(bucket1);
        
        Goods goods2 = new Goods("BC", 3);
        goodsRepository.create(goods2);
        Client client2 = new Client("client2", 4);
        clientRepository.create(client2);
        
        Bucket bucket2 = new Bucket(1, 1);
        bucketRepository.create(bucket2);

        List actualResult = bucketRepository.findAll();
        for (Object g : actualResult) {
            System.out.println(g);
        }
        Assert.assertEquals(2, actualResult.size());
    }
    
    @Test
    public void testFind(){
        System.out.println("Test 5");
        Goods goods = new Goods("ABC", 1);
        goodsRepository.create(goods);
        Client client = new Client("client", 2);
        clientRepository.create(client);
        
        Bucket bucket = new Bucket(0, 0);
        bucketRepository.create(bucket);
        
        Bucket res = bucketRepository.find(0);
        Assert.assertEquals(res, bucket);
    }
    
}
