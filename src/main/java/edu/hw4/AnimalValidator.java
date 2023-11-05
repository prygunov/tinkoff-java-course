package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnimalValidator {

    private AnimalValidator() {

    }

    public static Map<String, Set<ValidationError>> validateAnimals(List<Animal> animals) {
        Map<String, Set<ValidationError>> errors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> animalErrors = new HashSet<>();

            if (animal.name() == null) {
                animalErrors.add(ValidationError.NAME_IS_NULL);
            } else if (animal.name().isEmpty()) {
                animalErrors.add(ValidationError.NAME_IS_EMPTY);
            }

            if (animal.type() == null) {
                animalErrors.add(ValidationError.TYPE_IS_NULL);
            }

            if (animal.sex() == null) {
                animalErrors.add(ValidationError.SEX_IS_NULL);
            }

            if (animal.age() < 0) {
                animalErrors.add(ValidationError.NEGATIVE_AGE);
            }

            if (animal.height() <= 0) {
                animalErrors.add(ValidationError.NEGATIVE_HEIGHT);
            }

            if (animal.weight() <= 0) {
                animalErrors.add(ValidationError.NEGATIVE_WEIGHT);
            }

            if (!animal.bites() && animal.type() == Animal.Type.SPIDER) {
                animalErrors.add(ValidationError.SPIDER_DOESNT_BITE);
            }

            if (!animalErrors.isEmpty()) {
                errors.put(animal.name(), animalErrors);
            }
        }

        return errors;
    }

    public static Map<String, String> validateAnimalsReadable(List<Animal> animals) {
        Map<String, Set<ValidationError>> errors = validateAnimals(animals);
        Map<String, String> readableErrors = new HashMap<>();

        for (Map.Entry<String, Set<ValidationError>> entry : errors.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for (ValidationError error : entry.getValue()) {
                sb.append(error.getMessage()).append(", ");
            }
            if (!entry.getValue().isEmpty()) {
                sb.delete(sb.length() - 2, sb.length()); // remove last comma and space
            }
            readableErrors.put(entry.getKey(), sb.toString());
        }

        return readableErrors;
    }

}

