package core.basesyntax.Imp;

import core.basesyntax.Model.Fruit;
import core.basesyntax.Model.FruitRecordDto;
import core.basesyntax.Model.Storage;
import core.basesyntax.Service.Validator;

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
