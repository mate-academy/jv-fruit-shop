package core.basesyntax.service.strategy;

import core.basesyntax.storage.DataStorage;

public class BalanceOperation implements OperationAtFruit {
    private DataStorage dataStorage;

    @Override
    public void operation(String fruitName, int numberOfFruit) {
        DataStorage.fruitMap.put(fruitName, numberOfFruit);
    }
}
