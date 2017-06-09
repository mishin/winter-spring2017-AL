package base.studentFlowchartDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/studentFlowchart")
public class FlowchartRepositoryController {

    @Autowired
    private FlowchartRepository flowchartRepository;

    public FlowchartRepositoryController(FlowchartRepository repository) {
        flowchartRepository = repository;
    }

    @GetMapping("/aggregate")
    public List<CourseCountPair> aggregateFlowcharts() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (Flowchart item : flowchartRepository.findAll()) {
            for (PlannedCourse p : item.getPlannedCourses()) {
                String courseInfo = "Course ID: " + p.getCourseId() + ", " +
                                    "Year: " + p.getYear() + ", " +
                                    "Quarter: " + p.getQuarter();
                if (map.get(courseInfo) == null) {
                    map.put(courseInfo, 1);
                }
                else {
                    map.put(courseInfo, map.get(courseInfo) + 1);
                }
            }
        }

        AggregatePlannedCourseInformation agg = new AggregatePlannedCourseInformation();
        for (String key : map.keySet()) {
            agg.add(key, map.get(key));
        }
        return agg.getCourseCountPairs();
    }

    @GetMapping
    public ArrayList<Flowchart> listAll() {
        ArrayList<Flowchart> items = new ArrayList<Flowchart>();

        for (Flowchart item : flowchartRepository.findAll()) {
            items.add(item);
        }

        return items;
    }

    @GetMapping("student/{id}")
    public ArrayList<Flowchart> findByStudentId(@PathVariable Long id) {
        System.out.println("-----get student id: " + id);
        ArrayList<Flowchart> items = new ArrayList<Flowchart>();

        for (Flowchart item : flowchartRepository.findAll()) {
            System.out.println("---- item id: " + item.getStudentId());
            if (item.getStudentId() != null && item.getStudentId().toString().equals(id.toString())) {
                items.add(item);
            }
        }

        return items;
    }

    @GetMapping("{id}")
    public Flowchart findById(@PathVariable String id) {
        System.out.println("get id: " + id);
        for (Flowchart item : flowchartRepository.findAll()) {
            if (item.getId().toString().equals(id)) return item;
        }

        return null;
    }

    @PostMapping
    public Flowchart create(@RequestBody Flowchart input) {
        return flowchartRepository
                .save(new Flowchart(input.getStudentId(), input.getFlowchartName(), input.getPlannedCourses()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        flowchartRepository.delete(id);
    }

    @PutMapping("{id}")
    public Flowchart update(@PathVariable String id, @RequestBody List<PlannedCourse> input) {
        System.out.println("got here");
        for (PlannedCourse p : input) {
            System.out.println("c: " + p.getCourseId());
        }

        Flowchart flowchart = findById(id);

        if (flowchart == null) {
            System.out.println("flowchart null");
            return null;
        } else {
            System.out.println("flowchart not null");
            flowchart.setPlannedCourses(input);
            return flowchartRepository.save(flowchart);
        }
    }

    @PutMapping("{id}/name")
    public Flowchart updateName(@PathVariable String id, @RequestBody String newName) {
        Flowchart flowchart = findById(id);

        if (flowchart == null) {
            System.out.println("flowchart null");
            return null;
        } else {
            flowchart.setFlowchartName(newName);
            return flowchartRepository.save(flowchart);
        }
    }
}