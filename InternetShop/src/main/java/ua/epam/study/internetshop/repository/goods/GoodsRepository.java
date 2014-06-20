/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.study.internetshop.repository.goods;

import java.util.List;
import ua.epam.study.internetshop.domain.goods.*;

/**
 *
 * @author Artem_Kobeliev
 */
public interface GoodsRepository {
    
    Goods find(Integer id);
    List<?> findAll();
    boolean create(Goods goods);
    Goods findByName(String goodsName);
    
}
