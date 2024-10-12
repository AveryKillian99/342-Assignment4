package com.CSC340.Assignment4.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;



    public List<Animal> getAllAnimals() {
        return AnimalRepository.findAll();
    }

    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    public List<Animal> getAnimalsByClass(String species) {
        return animalRepository.getAnimalsByClass(species);
    }

    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }


    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setSpecies(animal.getSpecies());
        existing.setScientificName(animal.getScientificName());
        existing.setDescription(animal.getDescription());
        existing.setHabitat(animal.getHabitat());

        //Technically the 4 lines above are not necessary because the save method merges by default.
        animalRepository.save(existing);
    }


    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }


}
