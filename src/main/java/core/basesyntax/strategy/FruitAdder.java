package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class FruitAdder implements FruitHandler {
    @Override
    public void handle(String[] line) {
            Storage.storage.merge(line[INDEX_FRUIT],
                    Integer.parseInt(line[INDEX_AMOUNT]), Integer::sum);
    }
}
