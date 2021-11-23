package core.basesyntax.operationstrategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationFruitDto;

public class ReduceOperationService implements OperationService {
    @Override
    public void apply(OperationFruitDto operationFruitDto) {
        String nameFruit = operationFruitDto.getNameFruit();
        int quantity = operationFruitDto.getQuantity();
        for (Fruit fruit : Storage.fruits) {
            if (fruit.getQuantity() - quantity < 0) {
                throw new RuntimeException("Not enough fruits to buy!");
            }
            if (fruit.getName().equals(nameFruit)) {
                fruit.setQuantity(fruit.getQuantity() - quantity);
            }
        }
    }
}
