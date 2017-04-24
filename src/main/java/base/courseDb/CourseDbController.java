package base.courseDb;

/**
 * Created by Lauren on 4/6/2017.
 */

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/courseDb")
public class CourseDbController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public ArrayList<Course> listAll() {
        ArrayList<Course> items = new ArrayList<Course>();
        for (Course item : courseRepository.findAll()) {
            items.add(item);
        }
        return items;
    }

    @GetMapping("{id}")
    public Course find(@PathVariable Long id) {
        return courseRepository.findOne(id);
    }

    @PostMapping
    public Course create(@RequestBody Course input) {
        return courseRepository
                .save(new Course(input.getPrefix(), input.getNumber(), input.getTitle(), input.getEducationArea()));
    }

    public Course addCourse(Document course) {
        MongoCollection<Document> courseList = MongoController.db.getCollection("songs");
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        courseRepository.delete(id);
    }

    @PutMapping("{id}")
    public Course update(@PathVariable Long id, @RequestBody Course input) {
        Course course = courseRepository.findOne(id);
        if (course == null) {
            return null;
        } else {
            course.setNumber(input.getNumber());
            course.setPrefix(input.getPrefix());
            course.setTitle(input.getTitle());
            course.setEducationArea(input.getEducationArea());
            return courseRepository.save(course);
        }
    }
}
