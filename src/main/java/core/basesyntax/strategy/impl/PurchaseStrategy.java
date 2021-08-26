package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Integer amountFruitInStorage = Storage.getFruitsStorage().get(transactionDto.getFruit());
        Integer quantityPurchase = transactionDto.getQuantity();
        if (amountFruitInStorage == null) {
            throw new RuntimeException("This fruit is not on the balance sheet: "
                    + transactionDto.getFruit().getName());
        }
        if (amountFruitInStorage < quantityPurchase) {
            throw new RuntimeException("The amount of this fruit is not enough to buy: "
                    + transactionDto.getFruit().getName()
                    + " "
                    + quantityPurchase
                    + " pieces");
        }
        Storage.getFruitsStorage().put(transactionDto.getFruit(),
                amountFruitInStorage - quantityPurchase);
    }
}
