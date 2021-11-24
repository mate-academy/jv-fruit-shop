package core.basesyntax.operationstrategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationFruitDto;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void apply(OperationFruitDto operationFruitDto) {
        String nameFruit = operationFruitDto.getName();
        int quantity = operationFruitDto.getQuantity();
        for (Fruit fruit : Storage.fruits) {
            if (fruit.getName().equals(nameFruit)) {
                fruit.setQuantity(fruit.getQuantity()
                        + quantity);
                return;
            }
        }
        Storage.fruits.add(new Fruit(nameFruit, quantity));
    }
}
