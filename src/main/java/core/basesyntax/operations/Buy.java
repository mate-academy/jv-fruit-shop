package core.basesyntax.operations;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.Operation;

public class Buy implements StorageOperation {
    @Override
    public void doStorageOperation(Operation operation) {
        if (!FruitStorage.fruitStorage.containsKey(operation.getFruit())) {
            throw new RuntimeException("No such fruits in storage, check input file");
        }
        if (FruitStorage.fruitStorage.get(operation.getFruit()) < operation.getQuantity()) {
            throw new RuntimeException("Not enough fruits to sell");
        }
        if (FruitStorage.expiration.get(operation.getFruit()).isBefore(operation.getExpDate())) {
            throw new RuntimeException("You sold expired fruits, check input file");
        }
        operation.setQuantity(- operation.getQuantity());
        FruitStorage.fruitStorage.merge(operation.getFruit(),
                operation.getQuantity(),
                Integer::sum);
    }
}
