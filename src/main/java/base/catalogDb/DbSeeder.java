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
                1,
                "CPE",
                308,
                "Software Engineering",
                "major",
                4
        ));
//
//        BufferedReader br = new BufferedReader(new FileReader("coursecatalog.txt"));
//
//        try {
//            String currentLine;
//            CatalogCourse currentCourse;
//
//            while ((currentLine = br.readLine()) != null) {
//                System.out.println(currentLine);
//                String courseTokens[] = currentLine.split("},\\{");
//
//                for (String courseToken : courseTokens) {
//
//                    String tokens[] = courseToken.trim().split(",");
//                    currentCourse = new CatalogCourse(
//                            Integer.parseInt(tokens[0].split(":")[1].trim()),
//                            tokens[2].split(":")[1].trim().
//                                    substring(1, tokens[2].split(":")[1].trim().length()-1),
//                            Integer.parseInt(
//                                    tokens[3].split(":")[1].trim().
//                                    substring(1, tokens[3].split(":")[1].trim().length()-1)),
//
//                            tokens[4].split(":")[1].trim().
//                                    substring(1, tokens[4].split(":")[1].trim().length()-1),
//                            "major",
//                            Integer.parseInt(
//                                    tokens[5].split(":")[1].trim().
//                                    substring(1, tokens[5].split(":")[1].trim().length()-1))
//                    );
//                    courses.add(currentCourse);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        catalogRepository.deleteAll();
        catalogRepository.save(courses);
    }

}
