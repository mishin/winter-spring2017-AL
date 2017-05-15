package base.catalogDb;

import base.MongoController;
import com.mongodb.Mongo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by calvinnguyen on 5/7/17.
 */
@Component
public class DbSeeder implements CommandLineRunner {
    private CatalogRepository catalogRepository;

    public DbSeeder(CatalogRepository repository) {
        catalogRepository = repository;
    }

    @Override
    public void run(String ... strings) throws Exception {
        MongoController.loginMongo();
        CatalogDbController.collection = MongoController.getCollection("Course");
        /*
        Course cpe101 = new Course(
            "CPE",
            101,
            "Fundamentals of Computer Science",
            "",
            4
        );

        Course cpe202 = new Course(
            "CPE",
                    202,
                    "Data Structures",
                    "",
                    4
        );

        Course cpe203 = new Course(
            "CPE",
                    203,
                    "Project-Based Object-Oriented Programming and Design",
                    "",
                    4
        );

        catalogRepository.deleteAll();

        List<Course> courses = Arrays.asList(cpe203, cpe101, cpe202);
        catalogRepository.save(courses);
        */
    }
}
