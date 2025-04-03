package util;

import java.util.Random;

public class RandomBooleanGenerator implements LineGenerator{

    private final Random random = new Random();

    public RandomBooleanGenerator() {
    }

    public boolean tryGenerate() {
        return random.nextBoolean();
    }
}
