package xyz.itbs.sfgdi.controllers;

import org.springframework.stereotype.Controller;
import com.szu.pets.PetService;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String getBest(){
        return petService.sayBest();
    }
}
