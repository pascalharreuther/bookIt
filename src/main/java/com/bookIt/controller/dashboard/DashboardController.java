package com.bookIt.controller.dashboard;

import com.bookIt.model.dashboard.DashboardModel;
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
        ModelAndView modelAndView = new ModelAndView("modules/dashboard/dashboard");
        modelAndView.addObject("activeNavigationItem", 0);
        /*DashboardModel dashboardModel = new DashboardModel();
        modelAndView.addObject("dashboardModel", dashboardModel);*/
        return modelAndView;
    }
}
