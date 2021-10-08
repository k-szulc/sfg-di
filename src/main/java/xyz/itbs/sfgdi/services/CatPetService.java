package xyz.itbs.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"cat","default"})
@Service
public class CatPetService implements PetService {
    @Override
    public String sayBest() {
        return "Cat is the best !";
    }
}
