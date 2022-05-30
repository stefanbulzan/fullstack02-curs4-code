package ro.fasttrackit.curs4.homework;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        var personService = new PersonService(
                List.of(
                        new Person("Maria", 13),
                        new Person("Ion", 23),
                        new Person("Mihai", 55),
                        new Person("Margareta", 24),
                        new Person("Corina", 3),
                        new Person("Costel", 7),
                        new Person("Mirabela", 43)
                )
        );

        Function<String, String> fun = a -> a.substring(2);
        var groupedByAge = personService.groupByAgeRange(5, 15, 25);
        System.out.println(groupedByAge);
        var strings = groupedByAge.get(new Range(1, 1));
    }
}

record Person(String name, int age) {
}
