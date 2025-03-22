package com.example.marksmanagement.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            
            model.addAttribute("status", statusCode);
            
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("error", "Not Found");
                model.addAttribute("message", "The requested page could not be found.");
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("error", "Internal Server Error");
                model.addAttribute("message", "An internal server error occurred. Please try again later.");
            } else {
                model.addAttribute("error", "Error");
                model.addAttribute("message", "An unexpected error occurred.");
            }
        } else {
            model.addAttribute("status", "Unknown");
            model.addAttribute("error", "Error");
            model.addAttribute("message", "An unexpected error occurred.");
        }
        
        return "error";
    }
} 