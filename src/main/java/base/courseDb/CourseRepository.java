package base.courseDb;

/**
 * Created by Lauren on 4/6/2017.
 */
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

}