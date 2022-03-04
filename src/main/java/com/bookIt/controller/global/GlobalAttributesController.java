package com.bookIt.controller.global;

import com.bookIt.database.entities.User;
import com.bookIt.database.services.CustomUserDetailsService;
import com.bookIt.login.LoginType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * Controller for global attributes
 */
@ControllerAdvice
public class GlobalAttributesController {
    Logger logger = LoggerFactory.getLogger(GlobalAttributesController.class);

    @Value("${bookIt.title:bookIt}")
    private String bookItTitle;
    @Value("${bookIt.debug:true}")
    private boolean debug;
    @Value("${bookIt.helpLink:https://www.google.com}")
    private String helpLink;
    @Value("${bookIt.loginType:USERNAMEPASSWORD}")
    private LoginType loginType;

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    /**
     * Add global attributes to global thymeleaf model for every html page
     * @param model
     */
    @ModelAttribute
    public void addGlobalAttributes(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = null;
            if(loginType == LoginType.EMAILPASSWORD){
                try {
                    user = customUserDetailsService.loadUserByEmail(currentUserName);
                } catch (UserPrincipalNotFoundException e) {
                    logger.error("Error at LoadUserByEmail: " + e.getMessage());
                }
            }else{
                try {
                user = customUserDetailsService.loadUserByUsername(currentUserName);
                } catch (UsernameNotFoundException | UserPrincipalNotFoundException e) {
                    logger.error("Error at LoadUserByEmail: " + e.getMessage());
                }
            }
            if(user != null)
                model.addAttribute("user", user);
        }
        model.addAttribute("bookItTitle", bookItTitle);
        model.addAttribute("debug", debug);
        model.addAttribute("helpLink", helpLink);
    }
}
