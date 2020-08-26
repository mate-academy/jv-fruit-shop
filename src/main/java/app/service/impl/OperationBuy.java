package app.service.impl;

import app.FruitStorage;
import app.model.Fruit;
import app.service.Operation;
import java.util.List;

public class OperationBuy implements Operation {

    @Override
    public void doOperation(List<String> fruit) {
        Fruit currentFruit = new FruitParserImplements().parse(fruit);
        for (Fruit iteratorFruit : FruitStorage.fruits) {
            if (iteratorFruit.getName().equals(currentFruit.getName())
                    && iteratorFruit.getEndOfShelfLife().isAfter(currentFruit.getEndOfShelfLife())
                    || iteratorFruit.getEndOfShelfLife().equals(currentFruit.getEndOfShelfLife())) {
                if (currentFruit.getQuantity() < iteratorFruit.getQuantity()) {
                    iteratorFruit.setQuantity(iteratorFruit.getQuantity()
                            - currentFruit.getQuantity());
                    currentFruit.setQuantity(0);
                    return;
                } else {
                    currentFruit.setQuantity(currentFruit.getQuantity()
                            - iteratorFruit.getQuantity());
                    iteratorFruit.setQuantity(0);
                }

            }
        }
        throw new RuntimeException("Not enough " + currentFruit.getName() + "in stock for sale");
    }
}
