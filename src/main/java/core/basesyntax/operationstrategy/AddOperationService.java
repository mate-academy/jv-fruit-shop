package core.basesyntax.operationstrategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationFruitDto;

public class AddOperationService implements OperationService {
    @Override
    public void apply(OperationFruitDto operationFruitDto) {
        String nameFruit = operationFruitDto.getNameFruit();
        int quantity = operationFruitDto.getQuantity();
        for (int i = 0; i < Storage.fruits.size(); i++) {
            Fruit currentFruit = Storage.fruits.get(i);
            if (currentFruit.getName().equals(nameFruit)) {
                currentFruit.setQuantity(currentFruit.getQuantity()
                        + quantity);
                return;
            }
        }
        Storage.fruits.add(new Fruit(nameFruit, quantity));
    }
}
