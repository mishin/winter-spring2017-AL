package base.flowchartDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Lauren on 4/6/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/flowchartDb")
public class FlowchartDbController {

    @Autowired
    private FlowchartRepository flowchartRepository;

    @GetMapping
    public ArrayList<Flowchart> listAll() {
        ArrayList<Flowchart> flowcharts = new ArrayList<Flowchart>();
        for (Flowchart item : flowchartRepository.findAll()) {
            flowcharts.add(item);
        }
        return flowcharts;
    }

    @GetMapping("{id}")
    public Flowchart find(@PathVariable Long id) {
        return flowchartRepository.findOne(id);
    }

    @PostMapping
    public Flowchart create(@RequestBody Flowchart input) {
        return flowchartRepository
                .save(new Flowchart(input.getStudentId(), input.getName(), input.getPlannedCourseIds()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        flowchartRepository.delete(id);
    }

    @PutMapping("{id}")
    public Flowchart update(@PathVariable Long id, @RequestBody Flowchart input) {
        Flowchart flowchart = flowchartRepository.findOne(id);
        if (flowchart == null) {
            return null;
        } else {
            flowchart.setStudentId(input.getStudentId());
            flowchart.setName(input.getName());
            flowchart.setPlannedCourseIds(input.getPlannedCourseIds());
            return flowchartRepository.save(flowchart);
        }
    }
}