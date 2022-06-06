package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class FruitSubtractor implements FruitHandler {
    @Override
    public void handle(String[] line) {
        Storage.getStorage().merge(line[INDEX_FRUIT], Integer.parseInt(line[INDEX_AMOUNT]), (a, b) -> {
            if (a - b < 0) {
                throw new RuntimeException("Do not have enough fruits for purchasing");
            }
            return a - b;
        });
    }
}
