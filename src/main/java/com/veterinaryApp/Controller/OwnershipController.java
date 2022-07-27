package com.veterinaryApp.Controller;

import com.veterinaryApp.Animal;
import com.veterinaryApp.Owner;
import com.veterinaryApp.Repository.AnimalRepository;
import com.veterinaryApp.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OwnershipController {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping({"/animals/ownershipAnimal"})
    public ModelAndView getOwnershipForm(@RequestParam Integer animalId){
        ModelAndView modelAndView = new ModelAndView("animals-ownership");
        List<Owner> owners = ownerRepository.findAll();
        Animal animal = animalRepository.findById(animalId).get();
        modelAndView.addObject("owners", owners);
        modelAndView.addObject("animal", animal);
        return modelAndView;
    }

}
