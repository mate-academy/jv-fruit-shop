package core.basesyntax.service;

import core.basesyntax.model.Operation;
import java.util.List;

public interface FruitService {
    void createNewFruit(String fruitName, int quantity);

    int getOperatedCount(int oldFruitQuantity, int newFruitQuantity, Operation operation);

    void createFruitsFromList(List<String> fruitRecords);
}
