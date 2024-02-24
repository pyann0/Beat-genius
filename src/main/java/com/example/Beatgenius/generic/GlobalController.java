package com.example.Beatgenius.generic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@Controller
@ControllerAdvice  // Indique des traitements (@ModelAttribute, @ExceptionHandler, ...) devant être exécutés par tous les controllers de mon application
public class GlobalController {

    @ExceptionHandler({SQLException.class})
    public String error(SQLException ex, Model model) {
        //model.addAttribute("message", ex.getMessage());
        model.addAttribute("message", "Une erreur SQL empêche la modification demandée.");
        return "error";
    }
}
