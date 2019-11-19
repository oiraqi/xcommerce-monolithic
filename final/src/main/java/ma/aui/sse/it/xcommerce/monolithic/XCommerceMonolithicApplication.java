package ma.aui.sse.it.xcommerce.monolithic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.User;
import ma.aui.sse.it.xcommerce.monolithic.security.UserAuditor;

@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableCaching
public class XCommerceMonolithicApplication {

	public static void main(String[] args) {
		SpringApplication.run(XCommerceMonolithicApplication.class, args);
	}

	@Bean
    AuditorAware<User> auditorProvider() {
        return new UserAuditor();
    }
}
