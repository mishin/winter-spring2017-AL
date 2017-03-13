package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // so framework can recognize this as a controller class
@RequestMapping("/flowchart")
public class FlowchartController {

    @GetMapping
    public String index() { return "flowchart.html"; }
}
