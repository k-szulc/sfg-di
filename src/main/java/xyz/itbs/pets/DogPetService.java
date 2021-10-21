package xyz.itbs.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dog")
@Service
public class DogPetService implements PetService {
    @Override
    public String sayBest() {
        return "Dog is the best !";
    }
}
