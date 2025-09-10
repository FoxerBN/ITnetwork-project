package sk.foxer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.foxer.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
