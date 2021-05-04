package core.basesyntax.strategy;

import core.basesyntax.database.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class IncreaseStrategy implements OperationStrategy {

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitRecordDto.getFruit();
        int updateQuantity = 0;
        if (!Storage.fruitStorage.containsKey(fruit)) {
            Storage.fruitStorage.put(fruit, fruitRecordDto.getQuantity());
        } else {
            int currentQuantity = Storage.fruitStorage.get(fruit);
            updateQuantity = currentQuantity + fruitRecordDto.getQuantity();
            Storage.fruitStorage.put(fruit, updateQuantity);
        }
        return updateQuantity;
    }
}
