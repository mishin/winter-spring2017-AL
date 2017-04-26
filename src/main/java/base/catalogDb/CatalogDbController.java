package base.catalogDb;

/**
 * Created by Lauren on 4/6/2017.
 */

/*
import base.mongoDb.MongoController;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/catalogDb")
public class CatalogDbController {

    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping
    public ArrayList<Course> listAll() {
        ArrayList<Course> items = new ArrayList<Course>();
        for (Course item : catalogRepository.findAll()) {
            items.add(item);
        }
        return items;
    }

    @GetMapping("{id}")
    public Course find(@PathVariable Long id) {
        return catalogRepository.findOne(id);
    }

    //MongoDB method
    /*public Course findCourse(Long id) {
        MongoDatabase db = MongoController.getDatabase();
        MongoCollection<Document> courseList = db.getCollection("Course");
        Document docId = new Document("Long", id);
        MongoCursor<Document> cursor = courseList.find(docId).iterator();
        return cursor.next();
    }*/

    @PostMapping
    public Course create(@RequestBody Course input) {
        return catalogRepository
                .save(new Course(input.getPrefix(), input.getNumber(), input.getTitle(),
                        input.getEducationArea(), input.getNumUnits()));
    }

    //MongoDB: Adds a document configured to course structure to the MongoDB Course collection
    /*public Course addCourse(Document course) {
        MongoDatabase db = MongoController.getDatabase();
        MongoCollection<Document> courseList = db.getCollection("Course");
        courseList.insertOne(course);
    }*/

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        catalogRepository.delete(id);
    }

    @PutMapping("{id}")
    public Course update(@PathVariable Long id, @RequestBody Course input) {
        Course course = catalogRepository.findOne(id);
        if (course == null) {
            return null;
        } else {
            course.setNumber(input.getNumber());
            course.setPrefix(input.getPrefix());
            course.setTitle(input.getTitle());
            course.setEducationArea(input.getEducationArea());
            course.setNumUnits(input.getNumUnits());
            return catalogRepository.save(course);
        }
    }
}
