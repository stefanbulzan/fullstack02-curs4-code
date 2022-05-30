package ro.fasttrackit.curs4.sealedClasses;

sealed interface Animal permits Dog, Cat, Bird, Fish {
}

record Bird(String name) implements Animal {

}

sealed interface Dog extends Animal {

}

non-sealed class Terrier implements Dog {

}

class LittleTerrier extends Terrier {

}

sealed class Cat implements Animal {
}

final class CommonCat extends Cat {
}

sealed interface Fish extends Animal permits Trout, Salmon {

}

record Salmon(int age) implements Fish {
}

sealed interface Trout extends Fish {

}

sealed interface PinkTrout extends Trout {

}

record AlaskaPinkTrout(String location) implements PinkTrout {
}

final class BlackTrout implements Trout {
}