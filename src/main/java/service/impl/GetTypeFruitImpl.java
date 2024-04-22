package service.impl;

import model.FruitType;
import service.GetTypeFruit;

import java.util.NoSuchElementException;

public class GetTypeFruitImpl implements GetTypeFruit {
    @Override
    public FruitType checkFruitType(String line) {
        return switch (line.toLowerCase()) {
            case "banana" -> FruitType.BANANA;
            case "apple" -> FruitType.APPLE;
            case "lemon" -> FruitType.LEMON;
            default -> throw new NoSuchElementException("FruitType " + line + " no such");
        };
    }
}
