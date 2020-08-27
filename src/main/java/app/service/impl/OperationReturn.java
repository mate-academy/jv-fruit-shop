package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruit;
import app.service.Operation;
import java.util.List;

public class OperationReturn implements Operation {
    @Override
    public void doOperation(List<String> data) {
        SupplyFruit currentFruit = new FruitParserImplements().parse(data);
        boolean isExist = false;
        for (SupplyFruit iteratorFruit : FruitStorage.supplyFruits) {
            if (iteratorFruit.getFruitName().equals(currentFruit.getFruitName())) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            throw new RuntimeException("The store does not sell this product");
        }
        for (SupplyFruit iteratorFruit : FruitStorage.supplyFruits) {
            if (iteratorFruit.getFruitName().equals(currentFruit.getFruitName())
                    && iteratorFruit.getEndOfShelfLife().equals(currentFruit.getEndOfShelfLife())) {
                iteratorFruit.setQuantity(iteratorFruit.getQuantity() + currentFruit.getQuantity());
                return;
            }
        }
        FruitStorage.supplyFruits.add(currentFruit);
    }
}
