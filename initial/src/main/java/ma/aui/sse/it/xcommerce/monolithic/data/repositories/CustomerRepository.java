package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Customer;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Omar IRAQI
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
}