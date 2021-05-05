package core.basesyntax.handler;

import core.basesyntax.database.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class IncreaseOperationHandler implements OperationHandler {

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitRecordDto.getFruit();
        Optional<Integer> quantity = Optional.ofNullable(Storage.fruitStorage.get(fruit));
        int currentQuantity = quantity.orElse(0);
        int updateQuantity = currentQuantity + fruitRecordDto.getQuantity();
        Storage.fruitStorage.put(fruit, updateQuantity);
        return updateQuantity;
    }
}
