package base.catalogDb;

/**
 * Created by Lauren on 4/6/2017.
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends MongoRepository<Course, String> {

}