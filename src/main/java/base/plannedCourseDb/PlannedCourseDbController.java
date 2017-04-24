package base.plannedCourseDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping("studentId/{id}")
    public Iterable<PlannedCourse> findByStudentId(@PathVariable Long id) {
        return plannedCourseRepository.findByStudentId(id);
    }

    @PostMapping
    public PlannedCourse create(@RequestBody PlannedCourse input) {
        return plannedCourseRepository
                .save(new PlannedCourse(input.getStudentId(), input.getCourseId(),
                        input.getQuarter(), input.getYear()));
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
            plannedCourse.setStudentId(input.getStudentId());
            plannedCourse.setCourseId(input.getCourseId());
            plannedCourse.setQuarter(input.getQuarter());
            plannedCourse.setYear(input.getYear());
            return plannedCourseRepository.save(plannedCourse);
        }
    }
}