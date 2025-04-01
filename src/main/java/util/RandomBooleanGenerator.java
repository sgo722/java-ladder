package util;

import java.util.Random;

public class RandomBooleanGenerator {

    private final Random random = new Random();

    public RandomBooleanGenerator() {
    }

    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
