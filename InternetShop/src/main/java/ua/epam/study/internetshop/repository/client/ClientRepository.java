/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.study.internetshop.repository.client;

import java.util.List;
import ua.epam.study.internetshop.domain.client.Client;

/**
 *
 * @author Artem_Kobeliev
 */
public interface ClientRepository {
    
    Client find(Integer id);
    List<?> findAll();
    boolean create(Client client);
    Client findByName(String clientName);
    
}
