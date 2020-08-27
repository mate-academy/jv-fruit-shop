package app.service.impl;

import app.FruitStorage;
import app.model.SupplyFruit;
import app.service.Operation;
import java.util.List;

public class OperationSupply implements Operation {
    @Override
    public void doOperation(List<String> data) {
        SupplyFruit currentFruit = new FruitParserImplements().parse(data);
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
