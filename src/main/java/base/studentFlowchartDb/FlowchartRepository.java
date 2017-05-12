package base.studentFlowchartDb;

import base.catalogCourseDb.CatalogCourse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Lauren on 4/6/2017.
 */
@RepositoryRestResource(collectionResourceRel = "flowcharts", path = "flowcharts")
public interface FlowchartRepository extends MongoRepository<Flowchart, String> {
    @Query( "{'studentId': ?0}" )
    List<Flowchart> findByStudentId(@Param("studentId") String studentId);

}
