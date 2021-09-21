package core.basesyntax.services.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class OperationBalance implements OperationHandler {
    @Override
    public Integer apply(FruitDto fruitDto) {
        Integer amountOfFruit = fruitDto.getAmountOfFruit();
        Storage.fruitRecordDto.put(new Fruit(fruitDto.getNameOfFruit()), amountOfFruit);
        return amountOfFruit;
    }
}
