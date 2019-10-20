package ma.aui.sse.it.xcommerce.monolithic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.aui.sse.it.xcommerce.monolithic.data.ShoppingCart;
import ma.aui.sse.it.xcommerce.monolithic.services.ShoppingCartService;

/**
 *
 * @author Omar IRAQI
 */
@RestController
@RequestMapping("/rest/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/get")
    public ShoppingCart getShoppingCart(){
        //Retrieve userId from JWT
        long userId = 1; //To be removed
        return shoppingCartService.getShoppingCart(userId);
    }

    @GetMapping("/addProduct")
    public ShoppingCart addProduct(@RequestParam long productId, 
                        @RequestParam int quantity){
        //Retrieve userId from JWT
        long userId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.addProduct(shoppingCart, userId, productId, quantity);
    }

    @GetMapping("/decreaseProductQuantity")
    public ShoppingCart removeProduct(@RequestParam long productId, 
                        @RequestParam int quantity){
        //Retrieve userId from JWT
        long userId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.removeProduct(shoppingCart, userId, productId, quantity);
    }

    @GetMapping("/removeProduct")
    public ShoppingCart removeProduct(@RequestParam long productId){
        //Retrieve userId from JWT
        long userId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.removeProduct(shoppingCart, userId, productId);
    }
}