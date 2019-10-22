package ma.aui.sse.it.xcommerce.monolithic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.test.context.support.WithMockUser;

import ma.aui.sse.it.xcommerce.monolithic.data.DataPack;
import ma.aui.sse.it.xcommerce.monolithic.data.ShoppingCart;
import ma.aui.sse.it.xcommerce.monolithic.services.ShoppingCartService;

/**
 *
 * @author Omar IRAQI
 */
@RestController
@RequestMapping("/rest/shoppingCart")
@WithMockUser
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/get")
    public ShoppingCart getShoppingCart(/* Authentication auth */){
        //Retrieve userId from JWT-base security context
        //auth.getPrinciple()
        long userId = 1; //To be removed
        return shoppingCartService.getShoppingCart(userId);
    }

    @PatchMapping("/addProductQuantity")
    public ShoppingCart addProductQuantity(@RequestBody DataPack dataPack){
        //Retrieve userId from JWT-base security context
        //auth.getPrinciple()
        long userId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.addProductQuantity(shoppingCart, userId,
                                                dataPack.getProductId(),
                                                dataPack.getQuantity());
    }

    @PatchMapping("/removeProductQuantity")
    public ShoppingCart removeProductQuantity(@RequestBody DataPack dataPack){
        //Retrieve userId from JWT-base security context
        //auth.getPrinciple()
        long userId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.removeProductQuantity(shoppingCart, userId, dataPack.getProductId(),
                                                    dataPack.getQuantity());
    }

    @PatchMapping("/removeProduct")
    public ShoppingCart removeProduct(@RequestBody DataPack dataPack){
        //Retrieve userId from JWT-base security context
        //auth.getPrinciple()
        long userId = 1; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.removeProduct(shoppingCart, userId, dataPack.getProductId());
    }
}