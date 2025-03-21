package core.basesyntax.operationservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        int currentAmount = Storage.getQuantity(fruit);

        if (currentAmount < quantity) {
            throw new RuntimeException("Ошибка: Недостаточно " + fruit + " на складе! Требуется: "
                    + quantity + ", доступно: " + currentAmount);
        }

        Storage.putFruit(fruit, currentAmount - quantity);
    }
}
