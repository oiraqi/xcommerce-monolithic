package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Order;

/**
 *
 * @author Omar IRAQI
 */
public interface OrderRepository extends CrudRepository<Order, Long>{
    @Query("select o from Order o where o.user.id = ?1")
    List<Order> findByUser(long userId);
}