package base.majorDb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by calvinnguyen on 6/2/17.
 */
@Repository
public interface MajorRepository extends MongoRepository<MajorInformation, String> {
}
