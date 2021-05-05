package core.basesyntax.handler;

import core.basesyntax.database.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class DecreaseOperationHandler implements OperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitRecordDto.getFruit();
        Optional<Integer> quantity = Optional.ofNullable(Storage.fruitStorage.get(fruit));
        int currentQuantity = quantity.orElse(0);
        int requestedQuantity = fruitRecordDto.getQuantity();
        if (currentQuantity < requestedQuantity) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + requestedQuantity + " " + fruit
                    + " units, because they are only " + currentQuantity
                    + " units in stock.");
        }
        int updateQuantity = currentQuantity - requestedQuantity;
        Storage.fruitStorage.put(fruit, updateQuantity);
        return updateQuantity;
    }
}
