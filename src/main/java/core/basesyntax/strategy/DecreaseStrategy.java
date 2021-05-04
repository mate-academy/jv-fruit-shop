package core.basesyntax.strategy;

import core.basesyntax.database.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class DecreaseStrategy implements OperationStrategy {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitRecordDto.getFruit();
        int currentQuantity = Storage.fruitStorage.get(fruit);
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
