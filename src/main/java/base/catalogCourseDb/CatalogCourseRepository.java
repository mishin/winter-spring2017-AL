package base.catalogCourseDb;

/**
 * Created by Lauren on 4/6/2017.
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;

@RepositoryRestResource(collectionResourceRel = "catalogcourses", path = "catalogcourses")
public interface CatalogCourseRepository extends MongoRepository<CatalogCourse, String> {

    //public ArrayList<CatalogCourse> findByPreNum(String prefix, int number);

}