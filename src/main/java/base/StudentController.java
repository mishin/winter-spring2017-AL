package base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lauren on 4/6/2017.
 */
@Controller // so framework can recognize this as a controller class
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    public String flowchart() { return "studentPage.html"; }
}
