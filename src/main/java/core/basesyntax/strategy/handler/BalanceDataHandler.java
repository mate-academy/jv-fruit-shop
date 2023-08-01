package core.basesyntax.strategy.handler;

import core.basesyntax.storage.Storage;

public class BalanceDataHandler implements DataHandler {
    // b , banana, 1234

    @Override
    public void processData(String fruit, int quantity) {
        Storage.addFruits(fruit, quantity);
    }
}
