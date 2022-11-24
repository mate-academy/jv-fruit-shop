package core.basesyntax.service.imp;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ChangeFruitQuantityService;

public class AddFruitService implements ChangeFruitQuantityService {

    @Override
    public void calculateFruits(String fruit, int quantity) {
        int actualBalance = Storage.getBalance(fruit);
        Storage.changeBalance(fruit, actualBalance + quantity);
    }
}
