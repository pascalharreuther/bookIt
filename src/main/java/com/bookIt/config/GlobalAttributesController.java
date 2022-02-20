package com.bookIt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller for global attributes
 */
@ControllerAdvice
public class GlobalAttributesController {

    @Value("${bookIt.title:bookIt}")
    private String bookItTitle;
    @Value("${bookIt.debug:true}")
    private boolean debug;
    @Value("${bookIt.helpLink:https://www.google.com}")
    private String helpLink;

    /**
     * Add global attributes to global thymeleaf model for every html page
     * @param model
     */
    @ModelAttribute
    public void addGlobalAttributes(Model model){
        model.addAttribute("bookItTitle", bookItTitle);
        model.addAttribute("debug", debug);
        model.addAttribute("helpLink", helpLink);
    }
}
