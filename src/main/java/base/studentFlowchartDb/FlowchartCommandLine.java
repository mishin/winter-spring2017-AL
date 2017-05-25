package base.studentFlowchartDb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by calvinnguyen on 5/24/17.
 */
@Component
public class FlowchartCommandLine implements CommandLineRunner {
    private FlowchartRepository flowchartRepository;

    public FlowchartCommandLine(FlowchartRepository repository) {
        flowchartRepository = repository;
    }

    @Override
    public void run(String ... strings) throws Exception {

        PlannedCourse cpe101 = new PlannedCourse(
                1,
                2017,
                1,
                1
        );

        PlannedCourse cpe202 = new PlannedCourse(
                2,
                2017,
                2,
                1
        );

        PlannedCourse cpe203 = new PlannedCourse(
                3,
                2017,
                2,
                2
        );

        List<PlannedCourse> courses = Arrays.asList(cpe203, cpe101, cpe202);

        Flowchart chart = new Flowchart (
                1,
                "John",
                courses
        );

        List<Flowchart> charts = Arrays.asList(chart);

        //flowchartRepository.deleteAll();
        flowchartRepository.save(chart);
    }

}
