package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruit;
import app.service.Operation;
import java.util.List;

public class OperationBuy implements Operation {

    @Override
    public void doOperation(List<String> data) {
        SupplyFruit currentFruit = new FruitParserImplements().parse(data);
        for (SupplyFruit iteratorFruit : FruitStorage.supplyFruits) {
            if (iteratorFruit.getFruitName().equals(currentFruit.getFruitName())
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
        throw new RuntimeException("Not enough " + currentFruit.getFruitName() + "in stock for sale");
    }
}
