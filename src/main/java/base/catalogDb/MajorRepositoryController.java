package base.catalogDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by calvinnguyen on 6/2/17.
 */

@CrossOrigin
@RestController
@RequestMapping("/majorcatalog")
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

    @PostMapping
    public MajorInformation create(@RequestBody MajorInformation input) {
        return majorRepository
                .save(new MajorInformation(input.getMajor(), input.getColorInfo(), input.getDefaultFlowchart()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        majorRepository.delete(id);
    }

    @PutMapping("{id}")
    public MajorInformation update(@PathVariable String id, @RequestBody MajorInformation input) {
        MajorInformation catalog = majorRepository.findOne(id);
        if (catalog == null) {
            return null;
        } else {
            catalog.setMajor(input.getMajor());
            catalog.setColorInfo(input.getColorInfo());
            catalog.setDefaultFlowchart(input.getDefaultFlowchart());
            return majorRepository.save(catalog);
        }
    }
}
