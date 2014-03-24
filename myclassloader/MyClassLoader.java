/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassloader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Artem_Kobeliev
 */
public class MyClassLoader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        for (;;) {
            
        ClassLoader loader = new DynamicClassOverloader(new String[] {"."});

        // текущий каталог "." будет единственным каталогом поиска

        Class clazz = Class.forName("myclassloader.TestModule", true, loader);

        Object object= clazz.newInstance();

        System.out.println(object);

        new BufferedReader(new InputStreamReader(System.in)).readLine();
      }
    }
}
