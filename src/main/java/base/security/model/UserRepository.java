package base.security.model;

/**
 * Created by Marthxander on 5/8/2017.
 */
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByEmail(String email);
}
