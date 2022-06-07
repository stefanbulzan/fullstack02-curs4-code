package ro.fasttrackit.curs4.curs4Homework;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PureFunctions {

    public static void main(String[] args) {
        List<String> words = IntStream.range(1, 1_000)
                .mapToObj(index -> RandomStringUtils.randomAlphabetic(10))
                .toList();

        impure(words);
        pure(words);
        impure(words);
        pure(words);
        impure(words);
        pure(words);
        impure(words);
        pure(words);
    }

    private static void pure(List<String> words) {
        List<String> result = stopwatch("pure",
                () -> words.parallelStream()
                        .filter(word -> word.startsWith("A"))
                        .toList());
        System.out.println(result.size());
    }

    private static void impure(List<String> words) {
        List<String> out = stopwatch("impure", () -> {
            List<String> result = new ArrayList<>();
            words.stream()
                    .filter(word -> word.startsWith("A"))
                    .forEach(word -> result.add(word));
            return result;
        });
        System.out.println(out.size());
    }

    private static <T> T stopwatch(
            String name,
            Supplier<T> toRun) {
        long start = System.currentTimeMillis();
        T result = toRun.get();
        System.out.println(name + " took " + (System.currentTimeMillis() - start));
        return result;
    }
}
