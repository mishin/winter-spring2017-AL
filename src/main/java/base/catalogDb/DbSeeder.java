package base.catalogDb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by calvinnguyen on 5/7/17.
 */
@Component
public class DbSeeder implements CommandLineRunner {
    private CatalogRepository courseCatalog;

    @Override
    public void run(String ... strings) throws Exception {
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

        List<Course> courses = Arrays.asList(cpe101, cpe202, cpe203);
        courseCatalog.save(courses);
    }
}
