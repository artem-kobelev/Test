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

/**
 *
 * @author Artem_Kobeliev
 */
public class GoodsDAOJDBCTest extends DAOTestsTemplate {

    //@Autowired
    private GoodsRepositoryJDBC goodsRepository = context.getBean("goodsRepository",
            ua.epam.study.internetshop.repository.goods.GoodsRepositoryJDBC.class);

    //@Before
    @After
    public void clearDB() {
        System.out.println("clear my DB");
        //jdbcTemplate.execute("TRUNCATE TABLE Bucket");
        jdbcTemplate.execute("TRUNCATE TABLE Goods");
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
}
