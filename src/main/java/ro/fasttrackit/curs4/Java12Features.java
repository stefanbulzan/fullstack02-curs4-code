package ro.fasttrackit.curs4;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Java12Features {
    public static void main(String[] args) {
        teeingCollector();
        stringTransform();
        patternMatching("abcdefgh");
    }

    private static void patternMatching(Object object) {
        if (object instanceof String) {
            String name = (String) object;
            System.out.println(name.substring(3));
        }

        if (object instanceof String name) {
            System.out.println(name.substring(3));
        }
    }

    private static void stringTransform() {
        var transform = "Anamaria".transform(value -> value.substring(2));
        var transform2 = "Anamaria".substring(2);
        System.out.println(transform);
    }

    private static void teeingCollector() {
        Double average = IntStream.range(1, 100)
                .boxed()
                .collect(teeing(
                        summingDouble(t -> t),
                        counting(),
                        (sum, count) -> sum / count
                ));

        System.out.println(average);
    }
}
