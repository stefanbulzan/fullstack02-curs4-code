package ro.fasttrackit.curs4.poc;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> names = IntStream.range(1, 10_000_000)
                .mapToObj(index -> RandomStringUtils.randomAlphabetic(10))
                .toList();
        System.out.println("generated");
        impure(names);
        pure(names);
        impure(names);
        pure(names);
        impure(names);
        pure(names);
        impure(names);
        pure(names);
        impure(names);
        pure(names);
    }

    private static void pure(List<String> names) {
        List<String> result;
        long start;
        start = System.currentTimeMillis();
        result = getStringsWithAPure(names);
        System.out.println(" pure took " + (System.currentTimeMillis() - start));
    }

    private static void impure(List<String> names) {
        long start = System.currentTimeMillis();
        List<String> result = getStringsWithA(names);
        System.out.println("took " + (System.currentTimeMillis() - start));
    }

    private static List<String> getStringsWithA(List<String> names) {
        List<String> result = new ArrayList<>();
        names.parallelStream()
                .filter(elem -> elem.startsWith("a"))
                .forEach(result::add);
        System.out.println("result: " + result.size());
        return result;
    }

    private static List<String> getStringsWithAPure(List<String> names) {
        List<String> result = names.parallelStream()
                .filter(elem -> elem.startsWith("a"))
                .toList();
        System.out.println("pure result:" + result.size());
        return result;
    }
}
