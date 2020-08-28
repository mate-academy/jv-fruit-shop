package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruitBatch;
import app.service.Operation;
import java.util.List;

public class OperationBuy implements Operation {

    @Override
    public void execute(List<String> data) {
        SupplyFruitBatch currentFruit = new FruitParserImplementation().parse(data);
        for (SupplyFruitBatch iteratorFruit : FruitStorage.SUPPLY_FRUIT_BATCHES) {
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
        throw new RuntimeException("Not enough "
                + currentFruit.getFruitName() + "in stock for sale");
    }
}
