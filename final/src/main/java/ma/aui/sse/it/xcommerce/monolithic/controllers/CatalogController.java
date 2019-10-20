package ma.aui.sse.it.xcommerce.monolithic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Product;
//import ma.aui.sse.it.xcommerce.monolithic.data.entities.Category;
import ma.aui.sse.it.xcommerce.monolithic.services.CatalogService;

/**
 *
 * @author Omar IRAQI
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/init")
    public Iterable<Product> init(){
        return catalogService.init();
    }
}