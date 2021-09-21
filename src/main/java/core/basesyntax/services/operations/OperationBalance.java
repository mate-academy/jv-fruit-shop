package core.basesyntax.services.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class OperationBalance implements OperationHandler {
    @Override
    public int apply(FruitDto fruitDto) {
        int amountOfFruit = fruitDto.getAmountOfFruit();
        Storage.fruitStorage.put(new Fruit(fruitDto.getFruit().getName()), amountOfFruit);
        return amountOfFruit;
    }
}
