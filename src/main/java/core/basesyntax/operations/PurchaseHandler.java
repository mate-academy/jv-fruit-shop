package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperationDto;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int apply(FruitOperationDto fruitOperationDto) {
        for (Map.Entry<Fruit, Integer> mainStorage : Storage.storage.entrySet()) {
            if (fruitOperationDto.getFruit().equals(mainStorage.getKey())) {
                return mainStorage.getValue() - fruitOperationDto.getQuantity();
            }
        }
        throw new RuntimeException("Invalid operation");
    }
}
