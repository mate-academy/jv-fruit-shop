package core.basesyntax.imp;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FruitOperation;

public class FruitAdd implements FruitOperation {
    @Override
    public boolean operation(FruitRecordDto fruitRecordDto) {
        if (fruitRecordDto == null) {
            return false;
        }
        Fruit fruit = new Fruit(fruitRecordDto.getNameFruits());
        int storageFruit = Storage.fruits.get(fruit) == null ? 0 : Storage.fruits.get(fruit);
        int newAmountFruit = storageFruit + fruitRecordDto.getAmount();
        Storage.fruits.put(fruit, newAmountFruit);
        return true;
    }
}
