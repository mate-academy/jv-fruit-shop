package core.basesyntax.service.imp;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ChangeFruitQuantityService;

public class SetFruitBalance implements ChangeFruitQuantityService {

    @Override
    public void calculateFruits(String fruit, int quantity) {
        Storage.changeBalance(fruit,quantity);
    }
}
