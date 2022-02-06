package application.controllers;

import application.models.UserModel;
import application.service.DataInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/application")
public class RestController
{
    private DataInteractionService service;

    @Autowired
    public void setService(DataInteractionService service)
    {
        this.service = service;
    }

    @GetMapping("/readGET")
    public UserModel read(@ModelAttribute("object") UserModel userModel)
    {
        return service.getRepositoryUser().getByLogin(userModel.getLogin());
    }
    @PostMapping("/createPOST")
    public UserModel create(@ModelAttribute("object") UserModel userModel)
    {
        service.getRepositoryUser().save(userModel);
        return userModel;
    }
    @PutMapping("/updatePUT")
    public UserModel update(@ModelAttribute("object") UserModel userModel)
    {
        service.getRepositoryUser().update(userModel.getLogin() , userModel);
        return userModel;
    }
    @DeleteMapping("/deleteDELETE")
    public String delete(@ModelAttribute("object") UserModel userModel)
    {
        if (service.getRepositoryUser().getByLogin(userModel.getLogin()) != null)
        {
            service.getRepositoryUser().delete(userModel.getLogin());
            return "DELETED_SUCCESSFULLY";
        }
        return "NO_USERS_WERE_FOUND_BY_THESE_CREDENTIALS";
    }
}
