package spring.playground.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AccountConfiguration
 */
@Configuration
public class AccountConfiguration {

    @Bean
    UserDetailsService UserDetailsService(TestUserRepository accountRepository) {
        return username -> accountRepository.findByUsername(username).map(account -> {
            boolean active = account.isActive();
        })
    }
    
}