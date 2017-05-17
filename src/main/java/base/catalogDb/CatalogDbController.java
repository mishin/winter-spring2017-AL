package base.catalogDb;

/**
 * Created by Lauren on 4/6/2017.
 */

import base.catalogCourseDb.CatalogCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/CatalogCourse")
public class CatalogDbController {

    @Autowired
    private CatalogRepository catalogRepository;

    public CatalogDbController(CatalogRepository repository) {
        catalogRepository = repository;
    }

    @GetMapping
    public ArrayList<CatalogCourse> listAll() {
        ArrayList<CatalogCourse> items = new ArrayList<CatalogCourse>();

        for (CatalogCourse item : catalogRepository.findAll()) {
            items.add(item);
        }

        return items;
    }

    @GetMapping("{id}")
    public CatalogCourse find(@PathVariable String id) {
        return catalogRepository.findOne(id);
    }

    @PostMapping
    public CatalogCourse create(@RequestBody CatalogCourse input) {
        return catalogRepository
                .save(new CatalogCourse(input.getCourseId(), input.getPrefix(), input.getNumber(), input.getTitle(),
                        input.getEducationArea(), input.getNumUnits()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        catalogRepository.delete(id);
    }

    @PutMapping("{id}")
    public CatalogCourse update(@PathVariable String id, @RequestBody CatalogCourse input) {
        CatalogCourse CatalogCourse = catalogRepository.findOne(id);
        if (CatalogCourse == null) {
            return null;
        } else {
            CatalogCourse.setCourseId(input.getCourseId());
            CatalogCourse.setNumber(input.getNumber());
            CatalogCourse.setPrefix(input.getPrefix());
            CatalogCourse.setTitle(input.getTitle());
            CatalogCourse.setEducationArea(input.getEducationArea());
            CatalogCourse.setNumUnits(input.getNumUnits());
            return catalogRepository.save(CatalogCourse);
        }
    }
}

