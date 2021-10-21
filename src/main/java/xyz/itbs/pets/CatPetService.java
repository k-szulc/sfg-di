package xyz.itbs.pets;

public class CatPetService implements PetService {
    @Override
    public String sayBest() {
        return "Cat is the best !";
    }
}
