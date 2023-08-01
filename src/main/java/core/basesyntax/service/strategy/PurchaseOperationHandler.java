package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruitType = fruitTransaction.getFruit();
        if (FruitStorage.storageMap.get(fruitType) < fruitTransaction.getQuantity()) {
            throw new InvalidDataException("Not enough fruit in the store");
        }
        int newQuantity = FruitStorage.storageMap.get(fruitType) - fruitTransaction.getQuantity();
        FruitStorage.storageMap.put(fruitType, newQuantity);
    }
}

