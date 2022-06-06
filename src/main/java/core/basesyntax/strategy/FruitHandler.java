package core.basesyntax.strategy;

import java.util.List;

public interface FruitHandler {
    int INDEX_FRUIT = 1;
    int INDEX_AMOUNT = 2;

    void handle(List<String> fruitTypes, List<Integer> fruitAmount, String[] line);
}
