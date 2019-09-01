package ma.aui.sse.it.xcommerce.monolithic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class XCommerceMonolithicApplication {

	public static void main(String[] args) {
		SpringApplication.run(XCommerceMonolithicApplication.class, args);
	}

}
