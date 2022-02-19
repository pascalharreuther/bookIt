package com.bookIt.controller.participants;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParticipantsController {

    @GetMapping("/participants")
    public ModelAndView handleParticipants(){
        return new ModelAndView("participiants/participiants");
    }
}
