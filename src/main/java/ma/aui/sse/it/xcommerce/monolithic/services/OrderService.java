package ma.aui.sse.it.xcommerce.monolithic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import ma.aui.sse.it.xcommerce.monolithic.entities.Order;
import ma.aui.sse.it.xcommerce.monolithic.entities.OrderStatus;
import ma.aui.sse.it.xcommerce.monolithic.entities.Customer;
import ma.aui.sse.it.xcommerce.monolithic.entities.ShoppingCart;
import ma.aui.sse.it.xcommerce.monolithic.repositories.OrderRepository;

/**
 *
 * @author Omar IRAQI
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;

    public List<Order> getOrdersByCustomer(long customerId) {
        return orderRepository.findByCustomer(customerId);
    }

    public void checkout(ShoppingCart shoppingCart, Customer customer) {
        if(shoppingCart == null || customer == null 
                || shoppingCart.getProductsTotalPrice() == 0)
            return;

        Order order = new Order(shoppingCart, customer);
        orderRepository.save(order);
        shoppingCartService.empty(shoppingCart, customer.getId());
    }

    public void updateOrderStatus(long orderId, OrderStatus newStatus){
        Order order = orderRepository.findById(orderId).get();
        order.updateStatus(newStatus);
        orderRepository.save(order);
    }
}