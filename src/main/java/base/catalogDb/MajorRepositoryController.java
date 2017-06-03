package base.catalogDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by calvinnguyen on 6/2/17.
 */

@RequestMapping("/majorcatalog")
public class MajorRepositoryController {

    @Autowired
    private MajorRepository majorRepository;

    public MajorRepositoryController(MajorRepository repository) {
        majorRepository = repository;
    }

    @GetMapping
    public ArrayList<CourseEdArea> listAll() {
        ArrayList<CourseEdArea> items = new ArrayList<CourseEdArea>();

        for (CourseEdArea item : majorRepository.findAll()) {
            items.add(item);
        }

        return items;
    }

    @GetMapping("{id}")
    public CourseEdArea find(@PathVariable String id) {
        return majorRepository.findOne(id);
    }

    @PostMapping
    public CourseEdArea create(@RequestBody CourseEdArea input) {
        return majorRepository
                .save(new CourseEdArea(input.getCatalogId(), input.getMajor(), input.getCatalogCourses()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        majorRepository.delete(id);
    }

    @PutMapping("{id}")
    public CourseEdArea update(@PathVariable String id, @RequestBody CourseEdArea input) {
        CourseEdArea catalog = majorRepository.findOne(id);
        if (catalog == null) {
            return null;
        } else {
            catalog.setCatalogId(input.getCatalogId());
            catalog.setMajor(input.getMajor());
            catalog.setCatalogCourses(input.getCatalogCourses());
            return majorRepository.save(catalog);
        }
    }
}
