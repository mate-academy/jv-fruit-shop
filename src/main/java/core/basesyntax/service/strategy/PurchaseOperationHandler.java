package core.basesyntax.service.strategy;

import core.basesyntax.exceptions.InvalidDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruitType = fruitTransaction.getFruit();
        if (FruitStorage.storageMap.get(fruitType) < fruitTransaction.getQuantity()) {
            throw new InvalidDataException("There is not enough fruit to sell in the store, "
                    + "there are " + FruitStorage.storageMap.get(fruitType));
        }
        int newQuantity = FruitStorage.storageMap.get(fruitType) - fruitTransaction.getQuantity();
        FruitStorage.storageMap.put(fruitType, newQuantity);
    }
}

