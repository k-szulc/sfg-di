package com.szu.pets;

public class CatPetService implements PetService {
    @Override
    public String sayBest() {
        return "Cat is the best !";
    }
}
