package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruitBatch;
import app.service.Operation;

public class OperationSupply implements Operation {
    @Override
    public void execute(SupplyFruitBatch currentBatch) {
        for (SupplyFruitBatch iteratorFruit : FruitStorage.SUPPLY_FRUIT_BATCHES) {
            if (iteratorFruit.getFruitName().equals(currentBatch.getFruitName())
                    && iteratorFruit.getEndOfShelfLife().equals(currentBatch.getEndOfShelfLife())) {
                iteratorFruit.setQuantity(iteratorFruit.getQuantity() + currentBatch.getQuantity());
                return;
            }
        }
        FruitStorage.SUPPLY_FRUIT_BATCHES.add(currentBatch);
    }
}
