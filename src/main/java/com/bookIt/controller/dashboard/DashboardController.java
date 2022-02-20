package com.bookIt.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.TimeUnit;

/**
 * Controller for dashboard
 */
@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public ModelAndView handleDashboard(){

        return new ModelAndView("modules/dashboard/dashboard");
    }
}
