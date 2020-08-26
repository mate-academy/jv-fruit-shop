package app.service.impl;

import app.FruitStorage;
import app.model.Fruit;
import app.service.Operation;
import java.util.List;

public class OperationReturn implements Operation {
    @Override
    public void doOperation(List<String> fruit) {
        Fruit currentFruit = new FruitParserImplements().parse(fruit);
        boolean isExist = false;
        for (Fruit iteratorFruit : FruitStorage.fruits) {
            if (iteratorFruit.getName().equals(currentFruit.getName())) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            throw new RuntimeException("The store does not sell this product");
        }
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
