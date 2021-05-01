package core.basesyntax.Imp;

import core.basesyntax.Model.Fruit;
import core.basesyntax.Model.FruitRecordDto;
import core.basesyntax.Model.Storage;
import core.basesyntax.Service.FruitOperation;

public class FruitAdd implements FruitOperation {
    @Override
    public boolean operation(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getNameFruits());
        int storageFruit = Storage.fruits.get(fruit) == null ? 0 : Storage.fruits.get(fruit);
        int newAmountFruit = storageFruit + fruitRecordDto.getAmount();
        Storage.fruits.put(fruit, newAmountFruit);
        return true;
    }
}
