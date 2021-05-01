package core.basesyntax.imp;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FruitOperation;

public class FruitMinus implements FruitOperation {
    @Override
    public boolean operation(FruitRecordDto fruitRecordDto) {
        ValidatorImp validator = new ValidatorImp();
        validator.checkAmount(fruitRecordDto);
        Fruit fruit = new Fruit(fruitRecordDto.getNameFruits());
        Integer storageFruit = Storage.fruits.get(fruit);
        int newAmountFruit = storageFruit - fruitRecordDto.getAmount();
        Storage.fruits.put(fruit,newAmountFruit);
        return true;
    }
}
