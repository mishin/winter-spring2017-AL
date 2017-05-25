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
                .save(new CatalogCourse(input.getCourseId(), input.getPrefix(), input.getNumber(),
                        input.getTitle(), input.getEducationArea(), input.getDescription(),
                        input.getPrerequisites(), input.getNumUnits()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        catalogRepository.delete(id);
    }

    @PutMapping("{id}")
    public CatalogCourse update(@PathVariable String id, @RequestBody CatalogCourse input) {
        CatalogCourse catalogCourse = catalogRepository.findOne(id);
        if (catalogCourse == null) {
            return null;
        } else {
            catalogCourse.setCourseId(input.getCourseId());
            catalogCourse.setNumber(input.getNumber());
            catalogCourse.setPrefix(input.getPrefix());
            catalogCourse.setTitle(input.getTitle());
            catalogCourse.setEducationArea(input.getEducationArea());
            catalogCourse.setPrerequisites(input.getPrerequisites());
            catalogCourse.setDescription(input.getDescription());
            catalogCourse.setNumUnits(input.getNumUnits());
            return catalogRepository.save(catalogCourse);
        }
    }
}

