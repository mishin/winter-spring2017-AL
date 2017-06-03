package base.catalogDb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by calvinnguyen on 6/2/17.
 */
@Repository
public class MajorRepository extends MongoRepository<CourseEdArea, String> {
}
