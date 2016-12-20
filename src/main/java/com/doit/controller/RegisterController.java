package com.doit.controller;

import com.doit.data.User;
import com.doit.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
@Controller
public class RegisterController {

    private UserService userService;

    private MessageSource messageSource;

    @Autowired
    public RegisterController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String registeration() {
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("confirmPassword") String confirmPassword,
                           @Valid User user,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        if (StringUtils.isEmpty(confirmPassword)) {
            String message = messageSource.getMessage("err.field.confirm.password.required", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "password", message));
            return "register";
        }else if (!user.getPassword().equals(confirmPassword)) {
            String message = messageSource.getMessage("err.field.password.mismatched", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "password", message));
            return "register";
        }

        userService.add(user);

        return "redirect:login";
    }

}
