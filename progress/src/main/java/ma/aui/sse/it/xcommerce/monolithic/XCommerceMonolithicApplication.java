package ma.aui.sse.it.xcommerce.monolithic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class XCommerceMonolithicApplication {

	public static void main(String[] args) {
		SpringApplication.run(XCommerceMonolithicApplication.class, args);
	}

}
