package base.catalogDb;

import base.catalogCourseDb.CatalogCourse;
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

        CatalogCourse cpe101 = new CatalogCourse(
                1,
                "CPE",
                101,
                "Fundamentals of Computer Science",
                "",
                4
        );

        CatalogCourse cpe202 = new CatalogCourse(
                2,
                "CPE",
                202,
                "Data Structures",
                "",
                4
        );

        CatalogCourse cpe203 = new CatalogCourse(
                3,
                "CPE",
                203,
                "Project-Based Object-Oriented Programming and Design",
                "",
                4
        );

        catalogRepository.deleteAll();

        List<CatalogCourse> courses = Arrays.asList(cpe203, cpe101, cpe202);
        catalogRepository.save(courses);
    }

}
