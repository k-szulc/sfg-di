package xyz.itbs.pets;

public class DogPetService implements PetService {
    @Override
    public String sayBest() {
        return "Dog is the best !";
    }
}
