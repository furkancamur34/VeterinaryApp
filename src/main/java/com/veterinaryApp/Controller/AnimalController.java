package com.veterinaryApp.Controller;

import com.veterinaryApp.Animal;
import com.veterinaryApp.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelExtensionsKt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping({"/animals/list"})
    public ModelAndView getAllAnimals(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Animal> animalList = animalRepository.findAll();
        modelAndView.addObject("animals", animalList);
        return modelAndView;
    }

    @GetMapping({"/animals/addAnimalShow"})
    public ModelAndView addAnimalShow(){
        ModelAndView modelAndView = new ModelAndView("animals-add");
        Animal newAnimal = new Animal();
        modelAndView.addObject("animal", newAnimal);
        return modelAndView;

    }

    @PostMapping({"/addAnimalPost"})
    public String addAnimal(@ModelAttribute Animal animal){
        animalRepository.save(animal);
        return "redirect:/animals/list";
    }

    @GetMapping({"/animals/updateAnimalShow"})
    public ModelAndView updateAnimalShow(@RequestParam Integer animalId) {
        ModelAndView modelAndView = new ModelAndView("animals-update");
        Animal animal = animalRepository.findById(animalId).get();
        modelAndView.addObject("animal", animal);
        return modelAndView;
    }

    @GetMapping({"animals/deleteAnimal"})
    public String deleteAnimal(@RequestParam Integer animalId){
        animalRepository.deleteById(animalId);
        return "redirect:/animals/list";
    }
}
