package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // so framework can recognize this as a controller class
@RequestMapping("/flowchart")
public class FlowchartController {

    @GetMapping
    public String index() { return "flowchart.html"; }

}
