package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw4.Tasks.task1;
import static edu.hw4.Tasks.task2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW4Test {

    static List<List<Animal>> dataSource() {
        return List.of(
            List.of(
                new Animal("Max", Animal.Type.DOG, Animal.Sex.M, 5, 130, 65, true),
                new Animal("Buddy", Animal.Type.DOG, Animal.Sex.M, 3, 50, 20, false),
                new Animal("Lucy", Animal.Type.CAT, Animal.Sex.F, -1, 30, 10, false),
                new Animal("Oliver", Animal.Type.FISH, Animal.Sex.M, 1, -5, 0, false),
                new Animal("Oliver Dolphin", Animal.Type.FISH, Animal.Sex.M, 1, 1, 3, false),
                new Animal("Whiskers", Animal.Type.CAT, Animal.Sex.M, 4, 25, 5, true),
                new Animal("Fluffy", Animal.Type.DOG, Animal.Sex.F, 2, 40, 15, true),
                new Animal("Charlotte", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 0, false),
                new Animal("Peter", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 0, true),
                new Animal("Peter Parker", Animal.Type.SPIDER, Animal.Sex.M, 4, 170, 60, false)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask1(List<Animal> animals) {
        final Animal[] prevAnimal = {null};
        task1(animals).forEach(animal -> {
            if (prevAnimal[0] != null) {
                assertTrue(prevAnimal[0].height() < animal.height());
            } else {
                prevAnimal[0] = animal;
            }
        });
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask2(List<Animal> animals) {
        final Animal[] prevAnimal = {null};
        int size = 4;

        task2(animals, size).forEach(animal -> {
            if (prevAnimal[0] != null) {
                assertTrue(prevAnimal[0].weight() > animal.weight());
            } else {
                prevAnimal[0] = animal;
            }
        });

        assertEquals(size, task2(animals, size).size());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask3(List<Animal> animals) {
        assertEquals(2, Tasks.task3(animals).get(Animal.Type.CAT));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask4(List<Animal> animals) {
        assertEquals("Oliver Dolphin", Tasks.task4(animals).name());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask5(List<Animal> animals) {
        assertEquals(Animal.Sex.M, Tasks.task5(animals));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask6(List<Animal> animals) {
        assertEquals("Lucy", Tasks.task6(animals).get(Animal.Type.CAT).name());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask7(List<Animal> animals) {
        assertEquals("Max", Tasks.task7(animals).name());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask8(List<Animal> animals) {
        assertEquals("Max", Tasks.task8(animals, 150).name());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask9(List<Animal> animals) {
        assertEquals(38, Tasks.task9(animals));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask10(List<Animal> animals) {
        assertEquals(9, Tasks.task10(animals).size());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask11(List<Animal> animals) {
        assertEquals(1, Tasks.task11(animals).size());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask12(List<Animal> animals) {
        assertEquals(2, Tasks.task12(animals));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask13(List<Animal> animals) {
        assertEquals(2, Tasks.task13(animals).size());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask14(List<Animal> animals) {
        assertTrue(Tasks.task14(animals, 100));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask15(List<Animal> animals) {
        assertEquals(85, (int) Tasks.task15(animals, 3, 5).get(Animal.Type.DOG));

    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask16(List<Animal> animals) {
        List<Animal> result = Tasks.task16(animals);
        assertEquals("Whiskers", result.get(0).name());
        assertEquals("Peter Parker", result.get(9).name());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask17(List<Animal> animals) {
        assertFalse(Tasks.task17(animals));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask18(List<Animal> animals) {
        assertEquals("Oliver Dolphin", Tasks.task18(animals).name());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask19(List<Animal> animals) {
        Map<String, Set<ValidationError>> errors = Tasks.task19(animals);
        assertEquals(5, errors.size());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testTask20(List<Animal> animals) {
        Map<String, String> errors = Tasks.task20(animals);
        assertEquals(5, errors.size());
    }

}
