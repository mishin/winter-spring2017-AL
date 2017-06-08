package base.catalogDb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.FileReader;

import com.google.gson.Gson;

@Component
public class DbSeeder implements CommandLineRunner {
    private CatalogRepository catalogRepository;

    public DbSeeder(CatalogRepository repository) {
        catalogRepository = repository;
    }

    @Override
    public void run(String ... strings) throws Exception {
        //This code is run every time the project is deployed, locally or on heroku.
        //If you want to use this to seed, be aware that it will permanently affect the database.
//        catalogRepository.deleteAll();
//        List<CatalogCourseJson> jsonCourses = new ArrayList<CatalogCourseJson>();
//        List<CatalogCourse> courses = new ArrayList<CatalogCourse>();
//        Scanner in = new Scanner(new FileReader("coursecatalog.txt"));
//        Gson gson = new Gson();
//        String[] json = in.nextLine().split("},");
//
//        for (int i = 0; i < json.length; i++) {
//            json[i] += "}";
//            jsonCourses.add(gson.fromJson(json[i], CatalogCourseJson.class));
//            CatalogCourseJson temp = jsonCourses.get(i);
//            courses.add(new CatalogCourse(temp.getCourseId(),
//                    temp.getPrefix() + " " + temp.getNumber(),
//                    temp.getTitle(),
//                    temp.getDescription(),
//                    convertPrereq(temp.getPrerequisites()),
//                    4));
//        }
//
//        for (CatalogCourse c: courses) {
//            List<String> prereqId = new ArrayList<String>();
//            for(String p: c.getPrerequisites()) {
//                String id = containsName(courses, p);
//                if (id != null) prereqId.add(id);
//            }
//            c.setPrerequisites(prereqId);
//
//        }
//
//        in.close();
//        catalogRepository.insert(courses);
    }

}
