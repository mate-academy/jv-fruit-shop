package service.impl;

import java.util.NoSuchElementException;
import model.FruitType;
import service.FruitTypeParser;

public class FruitTypeParserImpl implements FruitTypeParser {
    @Override
    public FruitType checkAndGetFruitType(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Input line cannot be null");
        }

        for (FruitType fruitType : FruitType.values()) {
            if (fruitType.name().equalsIgnoreCase(line)) {
                return fruitType;
            }
        }

        throw new NoSuchElementException("No such fruit: " + line);
    }
}
