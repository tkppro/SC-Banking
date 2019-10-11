package vnuk.cse.scbanking.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("vnuk.cse.scbanking.repositories")
public class ApplicationConfiguration {
}
