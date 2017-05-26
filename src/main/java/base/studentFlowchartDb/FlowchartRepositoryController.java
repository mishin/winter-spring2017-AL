package base.studentFlowchartDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping
    public ArrayList<Flowchart> listAll() {
        ArrayList<Flowchart> items = new ArrayList<Flowchart>();

        for (Flowchart item : flowchartRepository.findAll()) {
            items.add(item);
        }

        return items;
    }

    @GetMapping("{id}")
    public Flowchart findByStudentId(@PathVariable String id) {

        for (Flowchart item : flowchartRepository.findAll()) {
            if (item.getStudentId().toString().equals(id)) return item;
        }

        //TODO use the given student ID to get the student's major
        //TODO then instead of returning a new, empty flowchart, we can return the default
        //TODO flowchart for that major.
        return new Flowchart();
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
        Flowchart flowchart = findByStudentId(id);
        if (flowchart == null) {
            System.out.println("flowchart null");
            return null;
        } else {
            System.out.println("flowchart not null");
            flowchart.setPlannedCourses(input);

            return flowchartRepository.save(flowchart);
        }
    }
}

