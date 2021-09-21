package core.basesyntax.services.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class OperationSupply implements OperationHandler {
    @Override
    public int apply(FruitDto fruitDto) {
        Fruit fruit = new Fruit(fruitDto.getNameOfFruit());
        int amountOfFruit = Storage.fruitRecordDto.getOrDefault(fruit, 0);
        int newAmount = amountOfFruit + fruitDto.getAmountOfFruit();
        Storage.fruitRecordDto.put(fruit, newAmount);
        return newAmount;
    }
}
