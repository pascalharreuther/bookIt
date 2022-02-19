package com.bookIt.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for index
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView handleIndex(){
        return new ModelAndView("redirect:/dashboard");
    }
}
