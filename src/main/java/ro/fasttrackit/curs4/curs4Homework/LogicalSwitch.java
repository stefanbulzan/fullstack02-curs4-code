package ro.fasttrackit.curs4.curs4Homework;

import lombok.Builder;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Map.entry;

public class LogicalSwitch {
    private final Map<Predicate<Person>, Function<Person, String>> logicalSwitch = Map.ofEntries(
            entry(this::personIsMajor, this::extractName),
            entry(p -> p.name().startsWith("A"), p -> "Incepe cu A mare"),
            entry(p -> p.name().length() > 10, this::extractName)
    );

    public String process(Person person) {
        return logicalSwitch.keySet().stream()
                .filter(entry -> entry.test(person))
                .map(entry -> logicalSwitch.get(entry).apply(person))
                .findFirst()
                .orElse(null);
    }

    private boolean personIsMajor(Person person) {
        return person.age() >= 18;
    }

    private String extractName(Person person) {
        return person.name();
    }

}

record Person(String name, int age) {
    Person(String name) {
        this(validate(name), 1);
    }

    private static String validate(String name) {
        return name == null ? "" : name;
    }
}

@Builder
record PersonDto(String myName, int myAge) {
}

class PersonMapper {
    public PersonDto of(Person person) {
        var personBuilder = PersonDto.builder();
        personBuilder.myName(person.name());

        return personBuilder.build();
    }
}