package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruitType = fruitTransaction.getFruit();
        int newQuantity = FruitStorage.storageMap.get(fruitType) + fruitTransaction.getQuantity();
        FruitStorage.storageMap.put(fruitType, newQuantity);
    }
}
