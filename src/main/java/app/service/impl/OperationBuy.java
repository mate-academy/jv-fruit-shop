package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruitBatch;
import app.service.Operation;

public class OperationBuy implements Operation {
    private static final int EMPTY_DELIVERY = 0;

    @Override
    public void execute(SupplyFruitBatch currentBatch) {
        for (SupplyFruitBatch iteratorFruit : FruitStorage.SUPPLY_FRUIT_BATCHES) {
            if (isTheFruitSuitableForSale(iteratorFruit, currentBatch)) {
                if (currentBatch.getQuantity() < iteratorFruit.getQuantity()) {
                    iteratorFruit.setQuantity(iteratorFruit.getQuantity()
                            - currentBatch.getQuantity());
                    currentBatch.setQuantity(EMPTY_DELIVERY);
                    return;
                } else {
                    currentBatch.setQuantity(currentBatch.getQuantity()
                            - iteratorFruit.getQuantity());
                    iteratorFruit.setQuantity(EMPTY_DELIVERY);
                }
            }
        }
        throw new RuntimeException("Not enough "
                + currentBatch.getFruitName() + "in stock for sale");
    }

    boolean isTheFruitSuitableForSale(SupplyFruitBatch iteratorFruit,
                                      SupplyFruitBatch currentFruit) {
        return iteratorFruit.getFruitName().equals(currentFruit.getFruitName())
                && iteratorFruit.getEndOfShelfLife().isAfter(currentFruit.getEndOfShelfLife())
                || iteratorFruit.getEndOfShelfLife().equals(currentFruit.getEndOfShelfLife());
    }
}
