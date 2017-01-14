package com.doit.controller;

import com.doit.data.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by SahakBabayan on 12/22/2016.
 */
@Controller
public class LoginController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(@AuthenticationPrincipal User user, @RequestParam Optional<String> error) {
        if (user != null) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login","error",error);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home(@AuthenticationPrincipal User user) {
        return "home";
    }

}
