/*
package base.catalogDb;

*/
/**
 * Created by Lauren on 4/6/2017.
 *//*


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/catalogDb")
public class CatalogCourseController {

    @Autowired
    private CatalogCourseRepository catalogCourseRepository;

    @GetMapping
    public ArrayList<CatalogCourse> listAll() {
        ArrayList<CatalogCourse> items = new ArrayList<CatalogCourse>();
        for (CatalogCourse item : catalogCourseRepository.findAll()) {
            items.add(item);
        }
        return items;
    }

    @GetMapping("{id}")
    public CatalogCourse find(@PathVariable Long id) {
        return catalogCourseRepository.findOne(id);
    }

    @PostMapping
    public CatalogCourse create(@RequestBody CatalogCourse input) {
        return catalogCourseRepository
                .save(new CatalogCourse(input.getCourseId(), input.getPrefix(), input.getNumber(),
                        input.getTitle(), input.getEducationArea(), input.getNumUnits()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        catalogCourseRepository.delete(id);
    }

    @PutMapping("{id}")
    public CatalogCourse update(@PathVariable Long id, @RequestBody CatalogCourse input) {
        CatalogCourse catalogCourse = catalogCourseRepository.findOne(id);
        if (catalogCourse == null) {
            return null;
        } else {
            catalogCourse.setCourseId(input.getCourseId());
            catalogCourse.setNumber(input.getNumber());
            catalogCourse.setPrefix(input.getPrefix());
            catalogCourse.setTitle(input.getTitle());
            catalogCourse.setEducationArea(input.getEducationArea());
            catalogCourse.setNumUnits(input.getNumUnits());
            return catalogCourseRepository.save(catalogCourse);
        }
    }
}
*/
