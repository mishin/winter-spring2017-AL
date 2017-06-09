package base.majorDb;

import base.studentFlowchartDb.Flowchart;
import base.studentFlowchartDb.PlannedCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by calvinnguyen on 6/2/17.
 */

@CrossOrigin
@RestController
@RequestMapping("/majorFlowchart")
public class MajorRepositoryController {

    @Autowired
    private MajorRepository majorRepository;

    public MajorRepositoryController(MajorRepository repository) {
        majorRepository = repository;
    }

    @GetMapping
    public ArrayList<MajorInformation> listAll() {
        ArrayList<MajorInformation> items = new ArrayList<MajorInformation>();

        for (MajorInformation item : majorRepository.findAll()) {
            items.add(item);
        }

        return items;
    }

    @GetMapping("{id}")
    public MajorInformation find(@PathVariable String id) {
        return majorRepository.findOne(id);
    }

    @GetMapping("major/{major}")
    public MajorInformation findByMajor(@PathVariable String major) {

        ArrayList<MajorInformation> items = new ArrayList<MajorInformation>();

        for (MajorInformation item : majorRepository.findAll()) {
            if (item.getMajor().equals(major)) return item;
        }

        return null;
    }

    @GetMapping("major/{major}/color")
    public ColorInfo findColor(@PathVariable String major) {
        ArrayList<MajorInformation> items = new ArrayList<MajorInformation>();

        for (MajorInformation item : majorRepository.findAll()) {
            if (item.getMajor().equals(major)) {
                return item.getColorInfo();
            }
        }

        return null;
    }

    @PostMapping
    public MajorInformation create() {
        Flowchart newFlowchart = new Flowchart();
        newFlowchart.setFlowchartName("New Flowchart");
        return majorRepository
                .save(new MajorInformation("no specific major", new ColorInfo(), newFlowchart));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        majorRepository.delete(id);
    }

    @PutMapping("major/{major}/rename/{newMajor}/{newName}")
    public MajorInformation updateNameAndMajor(@PathVariable String major, @PathVariable String newMajor,
                                               @PathVariable String newName) {
        MajorInformation item = findByMajor(major);

        if (item == null) {
            return null;
        } else {
            item.setMajor(newMajor);
            item.getDefaultFlowchart().setFlowchartName(newName);
            return majorRepository.save(item);
        }
    }

    @PutMapping("major/{major}")
    public MajorInformation update(@PathVariable String major, @RequestBody ArrayList<PlannedCourse> input) {
        MajorInformation item = findByMajor(major);

        if (item == null) {
            return null;
        } else {
            item.setPlannedCourses(input);
            return majorRepository.save(item);
        }
    }
}
