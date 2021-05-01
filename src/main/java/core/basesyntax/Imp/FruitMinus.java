package core.basesyntax.Imp;

import core.basesyntax.Model.Fruit;
import core.basesyntax.Model.FruitRecordDto;
import core.basesyntax.Model.Storage;
import core.basesyntax.Service.FruitOperation;

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
