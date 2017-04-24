package base.plannedCourseDb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Lauren on 4/6/2017.
 */

public interface PlannedCourseRepository extends CrudRepository<PlannedCourse, Long> {

    @Query("select p from PlannedCourse p WHERE p.studentId = :studentId")
    public Iterable<PlannedCourse> findByStudentId(@Param("studentId") Long studentId);
}