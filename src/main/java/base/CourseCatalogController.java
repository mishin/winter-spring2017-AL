package base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lauren on 4/7/2017.
 */
@Controller // so framework can recognize this as a controller class
@RequestMapping("/catalogApp")
public class CourseCatalogController {

    @GetMapping
    public String catalog() { return "catalog.html"; }
}
