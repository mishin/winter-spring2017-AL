package base.catalogDb;

import base.catalogCourseDb.CatalogCourse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

        List<CatalogCourse> courses = new ArrayList<CatalogCourse>();

        courses.add(new CatalogCourse(
                "1",
                "CPE",
                308,
                "Software Engineering I",
                "major",
                "",
                "",
                4
        ));

        catalogRepository.deleteAll();
        catalogRepository.save(courses);
    }

}
