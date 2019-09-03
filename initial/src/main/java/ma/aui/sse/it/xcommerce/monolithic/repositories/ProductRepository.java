/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.aui.sse.it.xcommerce.monolithic.repositories;

import ma.aui.sse.it.xcommerce.monolithic.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Omar IRAQI
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
        
        @Query("select p from Product p where p.name like %?1%")
        List<Product> findByName(String name);

        @Query("select p from Product p where p.name like %?1% and p.price between ?2 and ?3")
        List<Product> findByNameAndPrice(String name, float min, float max);

        @Query("select p from Product p where p.category.id = ?1 and p.price between ?2 and ?3")
        List<Product> findByCategoryAndPrice(long categoryId, float min, float max);

        @Query("select p from Product p where p.brand.id = ?1 and p.price between ?2 and ?3")
        List<Product> findByBrandAndPrice(long brandId, float min, float max);
}
