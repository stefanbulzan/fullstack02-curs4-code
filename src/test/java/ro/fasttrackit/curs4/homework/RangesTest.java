package ro.fasttrackit.curs4.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class RangesTest {
    @Test
    @DisplayName("WHEN no args in constructor THEN a single range is created")
    void whenNoArgsThen1RangeIsReturned() {
        Ranges ranges = new Ranges();

        assertThat(ranges.getRanges()).containsExactly(
                new Range(0, MAX_VALUE)
        );
    }

    @Test
    @DisplayName("WHEN 1 arg in constructor THEN [0, n], [n,MAX] ranges are created")
    void whenASingleArgIsGivenThen2Ranges() {
        Ranges ranges = new Ranges(10);
        assertThat(ranges.getRanges()).containsExactly(
                new Range(0, 10),
                new Range(10, MAX_VALUE)
        );
    }

    @Test
    @DisplayName("WHEN 2 arg in constructor THEN [0, n] [n,m] [m,MAX]")
    void test2Args() {
        Ranges ranges = new Ranges(10, 30);
        assertThat(ranges.getRanges()).containsExactly(
                new Range(0, 10),
                new Range(10, 30),
                new Range(30, MAX_VALUE)
        );
    }

    @Test
    @DisplayName("WHEN not sorted args in constructor THEN the intervals are sorted")
    void testNotSorted() {
        Ranges ranges = new Ranges(30, 18, 100);

        assertThat(ranges.getRanges()).containsExactly(
                new Range(0, 18),
                new Range(18, 30),
                new Range(30, 100),
                new Range(100, MAX_VALUE)
        );
    }

    @Test
    @DisplayName("WHEN args contain 0 THEN no extra interval is added in front")
    void testContainsZero() {
        Ranges ranges = new Ranges(0, 10, 20);

        assertThat(ranges.getRanges()).containsExactly(
                new Range(0, 10),
                new Range(10, 20),
                new Range(20, MAX_VALUE)
        );
    }

    @Test
    @DisplayName("WHEN args contain MAX  THEN no extra interval is added at the end")
    void testContainsMAX() {
        Ranges ranges = new Ranges(7, 10, 20, MAX_VALUE);

        assertThat(ranges.getRanges()).containsExactly(
                new Range(0, 7),
                new Range(7, 10),
                new Range(10, 20),
                new Range(20, MAX_VALUE)
        );
    }

    @Test
    @DisplayName("WHEN args contain negative values THEN we ignore them")
    void testNegativeValues() {
        Ranges ranges = new Ranges(-10, 7, 10, 20, MAX_VALUE);

        assertThat(ranges.getRanges()).containsExactly(
                new Range(0, 7),
                new Range(7, 10),
                new Range(10, 20),
                new Range(20, MAX_VALUE)
        );
    }

    @Test
    @DisplayName("WHEN args contain duplicate values THEN we don't duplicate interval")
    void testDuplicatedValues() {
        Ranges ranges = new Ranges(7, 10, 10, 20, MAX_VALUE);

        assertThat(ranges.getRanges()).containsExactly(
                new Range(0, 7),
                new Range(7, 10),
                new Range(10, 20),
                new Range(20, MAX_VALUE)
        );
    }


}