package com.bobocode.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Welcome controller that handles the GET request to "/welcome" and responds with a message.
 */
@Controller
public class WelcomeController {

    /**
     * Handles the GET request to "/welcome" and returns a simple message.
     *
     * @return the welcome message
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring MVC!"; // Response body without using a view
    }
}
