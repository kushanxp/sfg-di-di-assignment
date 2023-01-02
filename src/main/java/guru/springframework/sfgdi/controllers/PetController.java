package guru.springframework.sfgdi.controllers;

import guru.springframework.pets.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/28/19.
 */
@Controller
public class PetController {

    @Autowired
    @Qualifier("dogPetService")
    private PetService petService;

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
