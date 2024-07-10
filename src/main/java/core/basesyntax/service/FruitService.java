package core.basesyntax.service;

import core.basesyntax.model.Operations;
import java.util.List;

public interface FruitService {
    void addFruit(String fruitName, int quantity);

    int performOperation(int oldFruitQuantity, int newFruitQuantity, Operations operation);

    void addFruitFromList(List<String> fruitDocumentation);
}
