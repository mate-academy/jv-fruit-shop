package core.basesyntax.srategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class PurchaseHandler implements OperationHandler{
    @Override
    public int apply(FruitDto fruitDto) {
        if (!Storage.storage.containsKey(new Fruit(fruitDto.getName()))) {
            throw new RuntimeException(fruitDto.getName() + "isn't exist");
        }
        int count = Storage.storage.get(new Fruit(fruitDto.getName()));
        if (count - fruitDto.getCount() < 0) {
            throw new RuntimeException(fruitDto.getName() + "is not enough");
        }
        Storage.storage.put(new Fruit(fruitDto.getName()),count - fruitDto.getCount());
        return count - fruitDto.getCount();
    }
}
