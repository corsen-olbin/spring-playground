
package spring.playground.start;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestUserRepository extends JpaRepository<TestUser, Long> {

    Optional<TestUser> findByUserName(String username);
}