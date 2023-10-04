package core.basesyntax.strategy.handlers;

import core.basesyntax.storage.Storage;

public class SupplyDataHandler implements DataHandler {

    @Override
    public void processData(String fruit, int quantity) {
        Storage.addFruits(fruit, Storage.getFruits(fruit) + quantity);
    }
}
