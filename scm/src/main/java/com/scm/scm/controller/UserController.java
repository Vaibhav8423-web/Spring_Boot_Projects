package com.scm.scm.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.scm.entities.User;
import com.scm.scm.helper.Helper;
import com.scm.scm.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

        //user dashboard page
     
        @Autowired
        private UserService userService;

        Logger logger = LoggerFactory.getLogger(UserController.class);

        

        @RequestMapping(value = "/dashboard", method=RequestMethod.GET)
        public String userDashBoard() {
            return "user/dashboard";
        }

        //user profile page

        @RequestMapping(value = "/profile", method=RequestMethod.GET)
        public String userProfile(Model model,Authentication authentication) {
            
    
            return "user/profile";
        }
        
        //user add contacts page

        //user view contact 

        //user edit contact

        //user delete contact
}
