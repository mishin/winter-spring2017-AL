package base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lauren on 4/10/2017.
 */
@Controller // so framework can recognize this as a controller class
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping
    public String getAdministratorPage() { return "administratorPage.html"; }
}
