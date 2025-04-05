package model.util;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator{

    private final Random random = new Random();

    @Override
    public boolean nextBoolean() {
        return random.nextBoolean();
    }
}
