/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.study.internetshop.repository.bucket;

import java.util.List;
import ua.epam.study.internetshop.domain.bucket.Bucket;

/**
 *
 * @author Artem_Kobeliev
 */
public interface BucketRepository {
    
    Bucket find(Integer id);
    List<?> findAll();
    boolean create(Bucket bucket);
    
}
