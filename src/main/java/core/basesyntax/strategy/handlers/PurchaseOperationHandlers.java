package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CheckFruitExist;
import core.basesyntax.service.impl.CheckFruitExistImpl;

public class PurchaseOperationHandlers implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        CheckFruitExist checkFruitExist = new CheckFruitExistImpl();
        String fruit = transaction.getFruit();
        checkFruitExist.check(fruit);
        Integer quantity = transaction.getQuantity();
        Integer newQuantity = FruitStorage.storage.get(fruit) - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Balance can`t be negative");
        }
        FruitStorage.storage.put(fruit, newQuantity);
    }
}
