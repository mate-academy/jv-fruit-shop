package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitsHolderException;
import core.basesyntax.service.FruitsHolderService;

import java.util.HashMap;
import java.util.Map;

public class FruitsHolderServiceImpl implements FruitsHolderService {
    private static final int DEFAULT_VALUE = 0;
    private final Map<String, Integer> fruits;

    public FruitsHolderServiceImpl() {
        this.fruits = new HashMap<>();
    }

    @Override
    public void putFruit(String name, Integer amount) {
        if (name == null || amount == null) {
            throw new FruitsHolderException("Arguments must not be null");
        }
        fruits.put(name, amount);
    }

    @Override
    public int getFruitAmount(String name) {
        if (name == null) {
            throw new FruitsHolderException("Argument must not be null");
        }
        return fruits.getOrDefault(name, DEFAULT_VALUE);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return fruits;
    }
}
