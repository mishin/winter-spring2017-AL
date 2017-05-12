package base.catalogCourseDb;

/**
 * Created by Lauren on 4/6/2017.
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "catalogcourses", path = "catalogcourses")
public interface CatalogCourseRepository extends MongoRepository<CatalogCourse, String> {

}