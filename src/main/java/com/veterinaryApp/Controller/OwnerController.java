package com.veterinaryApp.Controller;

import com.veterinaryApp.Animal;
import com.veterinaryApp.Owner;
import com.veterinaryApp.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping({"/owners/list"})
    public ModelAndView getAllOwners(){
        ModelAndView modelAndView = new ModelAndView("owners-list");
        List<Owner> ownerList = ownerRepository.findAll();
        modelAndView.addObject("owners", ownerList);
        return modelAndView;
    }

    @GetMapping({"/owners/addOwnerShow"})
    public ModelAndView addOwnerShow(){
        ModelAndView modelAndView = new ModelAndView("owners-add");
        Owner newOwner = new Owner();
        modelAndView.addObject("owner", newOwner);
        return modelAndView;
    }

    @PostMapping({"/addOwnerPost"})
    public String addOwner(@ModelAttribute Owner owner){
        ownerRepository.save(owner);
        return "redirect:/owners/list";
    }

    @GetMapping({"/owners/updateOwnerShow"})
    public ModelAndView updateOwnerShow(@RequestParam Integer ownerId)
    {
        ModelAndView modelAndView = new ModelAndView("owners-update");
        Owner owner = ownerRepository.findById(ownerId).get();
        modelAndView.addObject("owner", owner);
        return modelAndView;
    }

    @GetMapping({"owners/deleteOwner"})
    public String deleteAnimal(@RequestParam Integer ownerId){
        ownerRepository.deleteById(ownerId);
        return "redirect:/owners/list";
    }
}
