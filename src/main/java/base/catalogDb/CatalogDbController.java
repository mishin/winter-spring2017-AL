package base.catalogDb;

/**
 * Created by Lauren on 4/6/2017.
 */

import base.MongoController;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/Course")
public class CatalogDbController {

    @Autowired
    private CatalogRepository catalogRepository;
    public static MongoCollection collection; //= MongoController.getCollection("Course");

    public CatalogDbController(CatalogRepository repository) {
        catalogRepository = repository;
    }

    @GetMapping
    public ArrayList<Course> listAll() {
        ArrayList<Course> items = new ArrayList<Course>();
        Document titleSort = new Document("prefix", 1).append("number", 1);
        //Document numberSort = new Document("number", 1);
        MongoCursor<Document> cursor = collection.find(new Document()).sort(titleSort).iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Course item = new Course(doc.getString("prefix"), doc.getInteger("number"),
                        doc.getString("title"), doc.getString("educationArea"),
                        doc.getInteger("numUnits"));
                items.add(item);
            }
        } finally {
            cursor.close();
        }
        /*
        for (Course item : catalogRepository.findAll()) {
            items.add(item);
        }
        */

        return items;
    }

    @GetMapping("{id}")
    public Course find(@PathVariable String id) {
        return catalogRepository.findOne(id);
    }

    @PostMapping
    public Course create(@RequestBody Course input) {
        //collection.insertOne(input.getDocument());
        return catalogRepository
                .save(new Course(input.getPrefix(), input.getNumber(), input.getTitle(),
                        input.getEducationArea(), input.getNumUnits()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        catalogRepository.delete(id);
    }

    @PutMapping("{id}")
    public Course update(@PathVariable String id, @RequestBody Course input) {
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

