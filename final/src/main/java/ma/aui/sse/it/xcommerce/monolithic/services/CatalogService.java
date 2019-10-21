package ma.aui.sse.it.xcommerce.monolithic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Brand;
import ma.aui.sse.it.xcommerce.monolithic.data.entities.Category;
import ma.aui.sse.it.xcommerce.monolithic.data.entities.Product;
import ma.aui.sse.it.xcommerce.monolithic.data.entities.Review;
import ma.aui.sse.it.xcommerce.monolithic.data.repositories.BrandRepository;
import ma.aui.sse.it.xcommerce.monolithic.data.repositories.CategoryRepository;
import ma.aui.sse.it.xcommerce.monolithic.data.repositories.ProductRepository;
import ma.aui.sse.it.xcommerce.monolithic.data.repositories.ReviewRepository;

/**
 *
 * @author Omar IRAQI
 */
@Service
public class CatalogService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Brand createBrand(String name){
        Brand brand = new Brand(name);
        brandRepository.save(brand);
        return brand;
    }

    public Category createCategory(String name, long parentCategoryId){
        Category category = new Category(name, categoryRepository.findById(parentCategoryId).get());
        categoryRepository.save(category);
        return category;
    }

    public Category createCategory(String name){
        Category category = new Category(name, null);
        categoryRepository.save(category);
        return category;
    }

    public Product createProduct(String name, String barcode, long brandId, long categoryId, float price, int quantity, float weight){
        Product product = new Product(name, barcode, brandRepository.findById(brandId).get(), 
                                categoryRepository.findById(categoryId).get(), price, quantity, weight);
        productRepository.save(product);
        return product;
    }

    public Review createReview(String eval, float grade, Product product){
        Review review = new Review(eval, grade, product);
        reviewRepository.save(review);
        return review;
    }

    public Iterable<Product> init(){

        Brand[] brands  = { 
            createBrand("Oppo"), 
            createBrand("Samsung"), 
            createBrand("Huwawei"),
            createBrand("Apple"),
            createBrand("Specialized"),
            createBrand("Scott")
        };
        
        Category[] rootCategories = {
            createCategory("Electronics"),
            createCategory("Bikes")
        };
        
        Category[] level1Categories = {
            createCategory("Phones", rootCategories[0].getId()),
            createCategory("Tabs", rootCategories[0].getId()),
            createCategory("Laptops", rootCategories[0].getId()),
            createCategory("Mountain Bikes", rootCategories[1].getId()),
            createCategory("XR", rootCategories[1].getId()),
            createCategory("Fat Bikes", rootCategories[1].getId())
        };
        
        Product[] products = {
            createProduct("F1", "647654765", brands[0].getId(), level1Categories[0].getId(), 4000, 5, 200),
            createProduct("F3", "643643663", brands[0].getId(), level1Categories[0].getId(), 2500, 5, 200),
            createProduct("XHR", "108970707", brands[1].getId(), level1Categories[1].getId(), 4000, 5, 200)
        };
        
        createReview("Good product", (float)4.5, products[0]);
        createReview("Pretty good product", (float)3.5, products[0]);
        createReview("Good product", (float)4.5, products[1]);
        createReview("Excellent product", 5, products[1]);

        return productRepository.findAll();
    }
}