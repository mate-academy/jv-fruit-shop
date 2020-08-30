package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruitBatch;
import app.service.Operation;
import java.util.List;

public class OperationReturn implements Operation {
    @Override
    public void execute(SupplyFruitBatch currentBatch) {
        boolean isExist = false;
        for (SupplyFruitBatch iteratorFruit : FruitStorage.SUPPLY_FRUIT_BATCHES) {
            if (iteratorFruit.getFruitName().equals(currentBatch.getFruitName())) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            throw new RuntimeException("The store does not sell this product");
        }
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
