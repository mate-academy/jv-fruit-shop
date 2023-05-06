package core.basesyntax.service;

import java.util.Map;

public interface FruitService {
    String getFruit(String fruitName);

    void addFruit(Map<String, Integer> remnantsOfGoods, String fruit, int quantity);

    void updateFruit(Map<String, Integer> remnantsOfGoods, String fruit, int addQuantity);
}
