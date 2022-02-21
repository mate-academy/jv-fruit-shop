package core.basesyntax.service.strategy;

import core.basesyntax.storage.DataStorage;

public class ReturnOperations implements OperationAtFruit {
    private DataStorage dataStorage;

    @Override
    public void operation(String fruitName, int numberOfFruit) {
        int sum = DataStorage.fruitMap.get(fruitName);
        DataStorage.fruitMap.put(fruitName, sum + numberOfFruit);
    }
}
