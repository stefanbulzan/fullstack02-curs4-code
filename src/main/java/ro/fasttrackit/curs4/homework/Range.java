package ro.fasttrackit.curs4.homework;

public record Range(int min, int max) {
    public boolean contains(int value) {
        return value >= min && value < max;
    }
}
