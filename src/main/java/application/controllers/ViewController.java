package application.controllers;

import application.models.UserModel;
import application.service.DataInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/application")
@Controller
public class ViewController
{
    private DataInteractionService service;

    @Autowired
    public void setService(DataInteractionService service)
    {
        this.service = service;
    }

    @GetMapping("/home")
    public String home(Model model)
    {
        model.addAttribute("users" , service.getRepositoryUser().getAll());
        return "home";
    }

    @GetMapping("/create")
    public String in(Model model)
    {
        model.addAttribute("object" , new UserModel());
        return "up";
    }

    @GetMapping("/read")
    public String read(Model model)
    {
        model.addAttribute("object" , new UserModel());
        return "read";
    }

    @GetMapping("/update")
    public String update(Model model)
    {
        model.addAttribute("object" , new UserModel());
        return "update";
    }

    @GetMapping("/delete")
    public String delete(Model model)
    {
        model.addAttribute("object" , new UserModel());
        return "delete";
    }
}