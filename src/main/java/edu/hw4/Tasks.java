package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

public class Tasks {

    public static final int TASK11_LIMIT = 100;

    private Tasks() {
    }

    static List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream()
            .filter(Objects::nonNull)
            .sorted((o1, o2) -> o2.weight() - o1.weight())
            .limit(k)
            .collect(Collectors.toList());
    }

    static Map<Animal.Type, Long> task3(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .collect(groupingBy(Animal::type, Collectors.counting()));
    }

    static Animal task4(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .max(Comparator.comparingInt(a -> a.name().length()))
            .orElseThrow();
    }

    static Animal.Sex task5(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .collect(groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .orElseThrow().getKey();
    }

    static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toMap(Animal::type, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    static Animal task7(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .max(Comparator.comparingInt(Animal::age))
            .orElseThrow();
    }

    static Animal task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.weight() < k)
            .max(Comparator.comparingInt(Animal::weight))
            .orElseThrow();
    }

    static int task9(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .mapToInt(Animal::paws)
            .sum();
    }

    static List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.age() != a.paws())
            .collect(Collectors.toList());
    }

    static List<Animal> task11(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(Animal::bites)
            .filter(a -> a.height() > TASK11_LIMIT)
            .collect(Collectors.toList());
    }

    static long task12(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.weight() > a.height())
            .count();
    }

    static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.name().split(" ").length > 1)
            .collect(Collectors.toList());
    }

    static boolean task14(List<Animal> animals, int k) {
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.type() == Animal.Type.DOG)
            .anyMatch(a -> a.height() > k);
    }

    static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int i) {
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.age() >= k)
            .filter(a -> a.age() <= i)
            .collect(groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    static boolean task17(List<Animal> animals) {
        // возможно перемудрил
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.type() == Animal.Type.SPIDER || a.type() == Animal.Type.DOG)
            .collect(groupingBy(Animal::type, Collectors.toList()))
            .entrySet()
            .stream()
            .map(e ->
                Map.entry(e.getKey(), e.getValue()
                    .stream()
                    .mapToInt(value -> value.bites() ? 1 : 0)
                    .summaryStatistics()))
            .max(Comparator.comparingDouble(
                value -> value.getValue().getAverage()))
            .get().getKey() == Animal.Type.SPIDER;
    }

    static Animal task18(List<Animal>... animals) {
        Animal fatFish = null;
        for (List<Animal> list : animals) {
            Optional<Animal> tempFatFish = list.stream()
                .filter(Objects::nonNull)
                .filter(a -> a.type() == Animal.Type.FISH)
                .max(Comparator.comparingInt(Animal::weight));

            if (tempFatFish.isEmpty()) {
                continue;
            }

            if (fatFish != null) {
                fatFish = tempFatFish.get().weight() > fatFish.weight() ? tempFatFish.get() : fatFish;
            } else {
                fatFish = tempFatFish.get();
            }
        }
        return fatFish;
    }

    static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        return AnimalValidator.validateAnimals(animals);
    }

    static Map<String, String> task20(List<Animal> animals) {
        return AnimalValidator.validateAnimalsReadable(animals);
    }
}
