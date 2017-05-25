package base.studentFlowchartDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    //@GetMapping("{id}")
    //public Flowchart find(@PathVariable String id) {
       // return flowchartRepository.findOne(id);
    //}

    @GetMapping("{id}")
    public Flowchart findByStudentId(@PathVariable String id) {

        for (Flowchart item : flowchartRepository.findAll()) {
            if (item.getStudentId().toString().equals(id)) return item;
        }

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
    public Flowchart update(@PathVariable String id, @RequestBody Flowchart input) {
        Flowchart flowchart = flowchartRepository.findOne(id);
        if (flowchart == null) {
            return null;
        } else {
            flowchart.setId(input.getId());
            flowchart.setFlowchartName(input.getFlowchartName());
            flowchart.setPlannedCourses(input.getPlannedCourses());

            return flowchartRepository.save(flowchart);
        }
    }
}

