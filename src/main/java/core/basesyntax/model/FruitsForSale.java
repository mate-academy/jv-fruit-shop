package core.basesyntax.model;

import java.util.List;

public class FruitsForSale {
    private static final List<String> fruitsForSale
            = List.of("banana", "apple");

    public boolean isNotForSale(String fruit) {
        for (String fruitFoSale: fruitsForSale) {
            if (fruitFoSale.equals(fruit)) {
                return false;
            }
        }
        return true;
    }
}
