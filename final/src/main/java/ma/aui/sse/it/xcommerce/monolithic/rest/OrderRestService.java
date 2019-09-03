package ma.aui.sse.it.xcommerce.monolithic.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import ma.aui.sse.it.xcommerce.monolithic.entities.Order;
import ma.aui.sse.it.xcommerce.monolithic.entities.OrderStatus;
import ma.aui.sse.it.xcommerce.monolithic.services.OrderService;
import ma.aui.sse.it.xcommerce.monolithic.services.ShoppingCartService;
import ma.aui.sse.it.xcommerce.monolithic.services.CustomerService;

/**
 *
 * @author Omar IRAQI
 */
@RestController
@RequestMapping("/order")
public class OrderRestService{

    @Autowired
    private OrderService orderService;
    @Autowired 
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public List<Order> getOrdersByCustomer() {
        //Retrieve customerId from JWT
        long customerId = 1; //To be removed
        return orderService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/checkout")
    public void checkout() {
        //Retrieve customerId from JWT
        long customerId = 1; //To be removed
        orderService.checkout(shoppingCartService.getShoppingCart(customerId), 
                customerService.getCustomer(customerId));
    }

    @GetMapping("/backOffice/list")
    public List<Order> getOrdersByCustomer(@RequestParam long customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/backOffice/updateStatus")
    public void updateOrderStatus(@RequestParam long orderId, @RequestParam int newStatus){
        switch(newStatus){
            case 1:
                orderService.updateOrderStatus(orderId, OrderStatus.SHIPPED);
                break;
            case 2:
                orderService.updateOrderStatus(orderId, OrderStatus.DELIVERED);
                break;
            case 3:
                orderService.updateOrderStatus(orderId, OrderStatus.ONHOLD);
                break;
            case 4:
                orderService.updateOrderStatus(orderId, OrderStatus.CANCELED);
                break;
        }        
    }
}