package com.bookIt.controller.seminars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeminarsController {

    @GetMapping("/seminars")
    public ModelAndView handleSeminars(){
        ModelAndView modelAndView = new ModelAndView("modules/seminars/seminars");
        modelAndView.addObject("activeNavigationItem", 1);
        return modelAndView;
    }
}
