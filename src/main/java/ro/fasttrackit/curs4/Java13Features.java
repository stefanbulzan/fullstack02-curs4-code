package ro.fasttrackit.curs4;

public class Java13Features {
    public static void main(String[] args) {
        textBlocks();
    }

    private static void textBlocks() {
        String poezie = """
                Poti scrie o
                             poezie
                Daca poezia
                E sintactic corecta
                """;
        System.out.println(poezie);

        System.out.println("""
                {
                    "name" : "Java",
                    "verb" : "%s",
                    "description": "%s"
                }
                """.formatted("Knows multiline formatting", poezie));
    }
}
