package ma.aui.sse.it.xcommerce.monolithic.repositories;

import ma.aui.sse.it.xcommerce.monolithic.entities.Review;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Omar IRAQI
 */
public interface ReviewRepository extends CrudRepository<Review, Long>{
    @Query("select r from Review r where r.product.id = ?1")
    List<Review> findByProduct(long productId);
}