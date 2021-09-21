package core.basesyntax.services.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class OperationPurchase implements OperationHandler {
    @Override
    public Integer apply(FruitDto fruitDto) {
        Fruit fruit = new Fruit(fruitDto.getNameOfFruit());
        Integer amountOfFruit = Storage.fruitRecordDto.getOrDefault(fruit, 0);
        Integer newAmount = amountOfFruit - fruitDto.getAmountOfFruit();
        if (newAmount < 0) {
            throw new RuntimeException("Not enough fruits in Storage.");
        }
        Storage.fruitRecordDto.put(fruit, newAmount);
        return newAmount;
    }
}
