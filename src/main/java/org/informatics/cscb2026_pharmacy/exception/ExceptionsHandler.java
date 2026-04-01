package org.informatics.cscb2026_pharmacy.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "org.informatics.cscb2026_pharmacy.controller.view")
public class ExceptionsHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public String handleException(ObjectNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/not-found-error";
    }

    @ExceptionHandler(Exception.class)
    protected String handleException(Exception exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/error";
    }
}

