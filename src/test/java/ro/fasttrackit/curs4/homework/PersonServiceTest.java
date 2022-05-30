package ro.fasttrackit.curs4.homework;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;

class PersonServiceTest {
    @Test
    @DisplayName("WHEN a list of persons THEN the persons are grouped correctly")
    void testList() {
        PersonService personService = new PersonService(
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
        Assertions.assertThat(personService.groupByAgeRange(5, 15, 25)).containsExactlyInAnyOrderEntriesOf(Map.of(
                new Range(0, 5), List.of(new Person("Corina", 3)),
                new Range(5, 15), List.of(new Person("Maria", 13), new Person("Costel", 7)),
                new Range(15, 25), List.of(new Person("Ion", 23), new Person("Margareta", 24)),
                new Range(25, MAX_VALUE), List.of(new Person("Mihai", 55), new Person("Mirabela", 43))
        ));
    }


}