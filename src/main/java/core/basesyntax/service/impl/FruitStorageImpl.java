package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitStorageImpl {
    public void calculateFruits() {
        for (FruitTransaction fruitTransaction : Storage.dataFromFile) {
            if (fruitTransaction.getFruit().equals("b")) {

            }
        }
    }
}
