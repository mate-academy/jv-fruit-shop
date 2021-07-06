package core.basesyntax.srategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class AdditionHandler implements OperationHandler {
    @Override
    public int apply(FruitDto fruitDto) {
        Fruit fruit = new Fruit(fruitDto.getName());
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException(fruit.getName() + "isn't exist");
        }
        int count = Storage.storage.get(fruit);
        int result = fruitDto.getQuantity() + count;
        Storage.storage.put(fruit, result);
        return result;
    }
}
