package com.bookIt.controller.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Controller for custom errors
 */
@Controller
public class CustomErrorController implements ErrorController {

    /**
     * Handle every request with "/error" (server.error.path=/error)
     * @param request
     * @return modelAndView
     */
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/error/default");
        modelAndView.addObject("errorStatusCode", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        modelAndView.addObject("errorRequestUri", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
        modelAndView.addObject("errorMessage", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        //modelAndView.addObject("errorException", request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
        return modelAndView;
    }
}
