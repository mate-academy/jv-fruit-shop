package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitService {
    String getFruit(String fruitName);

    void addFruit(Map<String, Integer> remnantsOfGoods, String fruit, int quantity);

    void updateFruit(FruitTransaction fruitTransaction, int toAdd);
}
