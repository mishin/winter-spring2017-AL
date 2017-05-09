package base.catalogDb;

/**
 * Created by Lauren on 4/6/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/Course")
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
    public Course find(@PathVariable String id) {
        return catalogRepository.findOne(id);
    }

    @PostMapping
    public Course create(@RequestBody Course input) {
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
