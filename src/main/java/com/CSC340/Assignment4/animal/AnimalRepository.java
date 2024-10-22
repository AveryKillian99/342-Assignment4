package com.CSC340.Assignment4.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalsBySpecies(String species);

    List<Animal> getAnimalsByName(String name);

}