package core.basesyntax.strategy.handler;

import core.basesyntax.storage.Storage;

public class ReturnDataHandler implements DataHandler {

    @Override
    public void processData(String fruit, int quantity) {
        Storage.addFruits(fruit, Storage.getFruits(fruit) + quantity);
    }
}
