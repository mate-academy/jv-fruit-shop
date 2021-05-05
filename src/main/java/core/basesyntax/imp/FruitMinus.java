package core.basesyntax.imp;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.Validator;

public class FruitMinus implements FruitOperation {
    private final Validator validator;

    public FruitMinus(Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean operation(FruitRecordDto fruitRecordDto) {
        if (fruitRecordDto == null) {
            return false;
        }
        validator.checkAmount(fruitRecordDto);
        Fruit fruit = new Fruit(fruitRecordDto.getNameFruits());
        Integer storageFruit = Storage.fruits.get(fruit);
        int newAmountFruit = storageFruit - fruitRecordDto.getAmount();
        Storage.fruits.put(fruit,newAmountFruit);
        return true;
    }
}
