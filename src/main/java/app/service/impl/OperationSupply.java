package app.service.impl;

import app.FruitStorage;
import app.model.Fruit;
import app.service.Operation;
import java.util.List;

public class OperationSupply implements Operation {
    @Override
    public void doOperation(List<String> fruit) {
        Fruit currentFruit = new FruitParserImplements().parse(fruit);
        for (Fruit iteratorFruit : FruitStorage.fruits) {
            if (iteratorFruit.getName().equals(currentFruit.getName())
                    && iteratorFruit.getEndOfShelfLife().equals(currentFruit.getEndOfShelfLife())) {
                iteratorFruit.setQuantity(iteratorFruit.getQuantity() + currentFruit.getQuantity());
                return;
            }
        }
        FruitStorage.fruits.add(currentFruit);
    }
}
