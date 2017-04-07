package base.plannedCourseDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Lauren on 4/6/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/plannedCourseDb")
public class PlannedCourseDbController {

    @Autowired
    private PlannedCourseRepository plannedCourseRepository;

    @GetMapping
    public ArrayList<PlannedCourse> listAll() {
        ArrayList<PlannedCourse> plannedCourses = new ArrayList<PlannedCourse>();
        for (PlannedCourse item : plannedCourseRepository.findAll()) {
            plannedCourses.add(item);
        }
        return plannedCourses;
    }

    @GetMapping("{id}")
    public PlannedCourse find(@PathVariable Long id) {
        return plannedCourseRepository.findOne(id);
    }

    @PostMapping
    public PlannedCourse create(@RequestBody PlannedCourse input) {
        return plannedCourseRepository
                .save(new PlannedCourse(input.getCourseId(), input.getQuarter()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        plannedCourseRepository.delete(id);
    }

    @PutMapping("{id}")
    public PlannedCourse update(@PathVariable Long id, @RequestBody PlannedCourse input) {
        PlannedCourse plannedCourse = plannedCourseRepository.findOne(id);
        if (plannedCourse == null) {
            return null;
        } else {
            plannedCourse.setCourseId(input.getCourseId());
            plannedCourse.setQuarter(input.getQuarter());
            return plannedCourseRepository.save(plannedCourse);
        }
    }
}