package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruitBatch;
import app.service.Operation;
import java.util.List;

public class OperationSupply implements Operation {
    @Override
    public void execute(List<String> data) {
        SupplyFruitBatch currentFruit = new FruitParserImplementation().parse(data);
        for (SupplyFruitBatch iteratorFruit : FruitStorage.SUPPLY_FRUIT_BATCHES) {
            if (iteratorFruit.getFruitName().equals(currentFruit.getFruitName())
                    && iteratorFruit.getEndOfShelfLife().equals(currentFruit.getEndOfShelfLife())) {
                iteratorFruit.setQuantity(iteratorFruit.getQuantity() + currentFruit.getQuantity());
                return;
            }
        }
        FruitStorage.SUPPLY_FRUIT_BATCHES.add(currentFruit);
    }
}
