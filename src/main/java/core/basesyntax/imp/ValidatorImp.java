package core.basesyntax.imp;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.Validator;

public class ValidatorImp implements Validator {
    @Override
    public boolean checkAmount(FruitRecordDto fruit) {
        Fruit checkFruit = new Fruit(fruit.getNameFruits());
        if (fruit.getAmount() < 0
                || Storage.fruits.get(checkFruit) == null) {
            throw new RuntimeException("Wrong fruit !");
        }
        return true;
    }
}
