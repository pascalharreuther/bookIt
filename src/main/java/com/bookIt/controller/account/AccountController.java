package com.bookIt.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @GetMapping("/account")
    public ModelAndView handleAccount(){
        ModelAndView modelAndView = new ModelAndView("modules/account/account");
        modelAndView.addObject("activeNavigationItem", 0);
        /*DashboardModel dashboardModel = new DashboardModel();
        modelAndView.addObject("dashboardModel", dashboardModel);*/
        return modelAndView;
    }
}
