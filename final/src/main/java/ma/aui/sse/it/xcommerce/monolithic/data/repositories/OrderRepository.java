package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Order;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Omar IRAQI
 */
public interface OrderRepository extends BaseRepository<Order>{
    @Query("select o from Order o where o.user.id = ?1")
    List<Order> findByCustomer(long userId);
}