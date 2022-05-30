package ro.fasttrackit.curs4.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;

public class PersonService {
    private final ArrayList<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = Optional.ofNullable(persons)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public Map<Range, List<Person>> groupByAgeRange(int... ages) {
        Ranges ranges = new Ranges(ages);
        return this.persons.stream()
                .collect(groupingBy(person -> ranges.getRange(person.age())));
    }
}
