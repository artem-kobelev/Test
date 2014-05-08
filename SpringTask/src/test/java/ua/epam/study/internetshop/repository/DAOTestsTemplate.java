/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.study.internetshop.repository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Artem_Kobeliev
 */

//@ContextConfiguration(locations = {"/persistenceContextTest.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
public class DAOTestsTemplate {
    
    protected static ApplicationContext context = new ClassPathXmlApplicationContext("persistanceContextTest.xml");
    
    protected JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", org.springframework.jdbc.core.JdbcTemplate.class);
    
}
