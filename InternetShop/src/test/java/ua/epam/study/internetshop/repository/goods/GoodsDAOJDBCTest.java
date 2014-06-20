/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.study.internetshop.repository.goods;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import ua.epam.study.internetshop.domain.goods.Goods;
import ua.epam.study.internetshop.repository.*;
import org.junit.After;
import org.junit.Before;
import ua.epam.study.internetshop.repository.bucket.BucketRepositoryJDBC;
import ua.epam.study.internetshop.repository.client.ClientRepositoryJDBC;

/**
 *
 * @author Artem_Kobeliev
 */
public class GoodsDAOJDBCTest extends DAOTestsTemplate {

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
        //jdbcTemplate.execute("TRUNCATE TABLE Bucket");
        //jdbcTemplate.execute("ALTER table Goods disable all foreign keys");
        //jdbcTemplate.execute("Delete from Goods");
        jdbcTemplate.execute("TRUNCATE SCHEMA PUBLIC RESTART IDENTITY AND COMMIT");
        
    }
    
    @Test
    public void testCreateGoodsNoExceptions() {
        System.out.println("my Test 1");
        Goods goods = new Goods("ABC", 1);
        goodsRepository.create(goods);
    }
    
    @Test
    public void testCreateGoods() {
        System.out.println("Test 2");
        Goods goods = new Goods("ABC", 1);
        goodsRepository.create(goods);

        int size = jdbcTemplate.queryForObject("select count(*) from Goods", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByNameGoods() {
        System.out.println("Test 3");
        Goods goods = new Goods("ABC", 1);
        goodsRepository.create(goods);

        Goods actualResult = goodsRepository.findByName("ABC");
        Assert.assertEquals(goods, actualResult);
    }

    @Test
    public void testFindAllGoods() {
        System.out.println("Test 4");
        Goods goods1 = new Goods("ABC", 1);
        Goods goods2 = new Goods("BC", 2);
        goodsRepository.create(goods1);
        goodsRepository.create(goods2);

        List actualResult = goodsRepository.findAll();
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
        Goods res = goodsRepository.find(0);
        Assert.assertEquals(res, goods);
    }
    
}
