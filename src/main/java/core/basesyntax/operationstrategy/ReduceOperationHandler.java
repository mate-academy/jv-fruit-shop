package core.basesyntax.operationstrategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationFruitDto;

public class ReduceOperationHandler implements OperationHandler {
    @Override
    public void apply(OperationFruitDto operationFruitDto) {
        String nameFruit = operationFruitDto.getName();
        int quantity = operationFruitDto.getQuantity();
        for (Fruit fruit : Storage.fruits) {
            if (fruit.getName().equals(nameFruit)) {
                if (fruit.getQuantity() - quantity < 0) {
                    throw new RuntimeException("Not enough fruits to buy!");
                }
                fruit.setQuantity(fruit.getQuantity() - quantity);
                return;
            }
        }
        throw new RuntimeException("We don't have such fruit to sell!");
    }
}
