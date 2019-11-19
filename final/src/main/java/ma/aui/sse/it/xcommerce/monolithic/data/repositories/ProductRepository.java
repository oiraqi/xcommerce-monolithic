/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Product;

/**
 *
 * @author Omar IRAQI
 */
@RepositoryRestResource
public interface ProductRepository extends BaseRepository<Product> {
        
        @Query("select p from Product p where p.name like %?1%")
        List<Product> findByName(String name);

        @Query("select p from Product p where p.name like %?1% and p.price between ?2 and ?3")
        List<Product> findByNameAndPrice(String name, float min, float max);

        @Query("select p from Product p where p.category.id = ?1")
        List<Product> findByCategory(long categoryId);

        @Query("select p from Product p where p.category.id = ?1 and p.price between ?2 and ?3")
        List<Product> findByCategoryAndPrice(long categoryId, float min, float max);

        @Query("select p from Product p where p.brand.id = ?1")
        List<Product> findByBrand(long brandId);

        @Query("select p from Product p where p.brand.id = ?1 and p.price between ?2 and ?3")
        List<Product> findByBrandAndPrice(long brandId, float min, float max);

        @Query("select p from Product p where p.category.id = ?1 and p.brand.id = ?2")
        List<Product> findByCategoryAndBrand(long categoryId, long brandId);

        @Query("select p from Product p where p.category.id =?1 and p.brand.id = ?2 and p.price between ?3 and ?4")
        List<Product> findByCategoryAndBrandAndPrice(long categoryId, long brandId, float min, float max);
}
