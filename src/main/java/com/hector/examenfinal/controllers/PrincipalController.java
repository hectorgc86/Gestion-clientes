package com.hector.examenfinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Controlador de principal
 
@Controller
public class PrincipalController 
{
	
	@GetMapping("/")
    public String principal(Model model) 
    {
        return "principal";
    }


}