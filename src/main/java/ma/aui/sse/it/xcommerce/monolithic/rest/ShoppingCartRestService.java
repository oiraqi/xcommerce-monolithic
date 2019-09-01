package ma.aui.sse.it.xcommerce.monolithic.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.aui.sse.it.xcommerce.monolithic.entities.ShoppingCart;
import ma.aui.sse.it.xcommerce.monolithic.services.ShoppingCartService;

/**
 *
 * @author Omar IRAQI
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartRestService {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/get")
    public ShoppingCart getShoppingCart(){
        //Retrieve customer from JWT
        long customerId = 1; //To be removed
        return shoppingCartService.getShoppingCart(customerId);
    }

    @GetMapping("/addProduct")
    public ShoppingCart addProduct(@RequestParam long productId, 
                        @RequestParam int quantity){
        //Retrieve customerId from JWT
        long customerId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(customerId);
        return shoppingCartService.addProduct(shoppingCart, customerId, productId, quantity);
    }

    @GetMapping("/decreaseProductQuantity")
    public ShoppingCart removeProduct(@RequestParam long productId, 
                        @RequestParam int quantity){
        //Retrieve customerId from JWT
        long customerId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(customerId);
        return shoppingCartService.removeProduct(shoppingCart, customerId, productId, quantity);
    }

    @GetMapping("/removeProduct")
    public ShoppingCart removeProduct(@RequestParam long productId){
        //Retrieve customerId from JWT
        long customerId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(customerId);
        return shoppingCartService.removeProduct(shoppingCart, customerId, productId);
    }
}