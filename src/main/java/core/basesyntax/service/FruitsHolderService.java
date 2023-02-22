package core.basesyntax.service;

import java.util.Map;

public interface FruitsHolderService {
    void putFruit(String name, Integer amount);

    int getFruitAmount(String name);

    Map<String, Integer> getAllFruits();
}
