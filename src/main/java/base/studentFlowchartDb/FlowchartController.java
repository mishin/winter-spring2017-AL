package base.studentFlowchartDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by calvinnguyen on 5/23/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/Flowchart")
public class FlowchartController {

    @Autowired
    private FlowchartRepository flowchartRepository;

    public FlowchartController(FlowchartRepository repository) {
        flowchartRepository = repository;
    }

    @GetMapping
    public ArrayList<Flowchart> listAll() {
        ArrayList<Flowchart> charts = new ArrayList<Flowchart>();

        for (Flowchart chart : flowchartRepository.findAll()) {
            charts.add(chart);
        }

        return charts;
    }

    @GetMapping("{id}")
    public Flowchart find(@PathVariable String id) {
        return flowchartRepository.findOne(id);
    }

    @PostMapping
    public Flowchart create(@RequestBody Flowchart input) {
        return flowchartRepository
                .save(new Flowchart(input.getStudentId(), input.getName(), input.getPlannedCourses()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        flowchartRepository.delete(id);
    }

    /*
    @DeleteMapping("{id}/{courseId}")
    public void delete(@PathVariable String id, @PathVariable String courseId) {
        Flowchart flowchart = flowchartRepository.findOne(id);
        if (flowchart != null) {
            List<PlannedCourse> courses = flowchart.getPlannedCourses();
            Iterator<PlannedCourse> courseIter = courses.iterator();
            PlannedCourse course;
            while(courseIter.hasNext()) {
                course = courseIter.next();
                if (course.getCourseId() == ) {
                    courses.remove(course);
                    break;
                }
            }
        }
    }
    */

    @PutMapping("{id}")
    public Flowchart update(@PathVariable String id, @RequestBody Flowchart input) {
        Flowchart flowchart = flowchartRepository.findOne(id);
        if (flowchart == null) {
            return null;
        } else {
            flowchart.setStudentId(input.getStudentId());
            flowchart.setName(input.getName());
            flowchart.setPlannedCourses(input.getPlannedCourses());
            return flowchartRepository.save(flowchart);
        }
    }
}
