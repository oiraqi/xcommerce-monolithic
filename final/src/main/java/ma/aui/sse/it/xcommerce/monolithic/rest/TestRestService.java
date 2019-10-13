package ma.aui.sse.it.xcommerce.monolithic.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.aui.sse.it.xcommerce.monolithic.entities.Product;
//import ma.aui.sse.it.xcommerce.monolithic.data.entities.Category;
import ma.aui.sse.it.xcommerce.monolithic.services.TestService;

/**
 *
 * @author Omar IRAQI
 */
@RestController
@RequestMapping("/test")
public class TestRestService {

    @Autowired
    private TestService testService;

    @GetMapping("/init")
    public Iterable<Product> init(){
        return testService.init();
    }
}