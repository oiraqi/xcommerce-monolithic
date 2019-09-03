package ma.aui.sse.it.xcommerce.monolithic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.aui.sse.it.xcommerce.monolithic.entities.Customer;
import ma.aui.sse.it.xcommerce.monolithic.repositories.CustomerRepository;

/**
 *
 * @author Omar IRAQI
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(long customerId){
        return customerRepository.findById(customerId).get();
    }
}