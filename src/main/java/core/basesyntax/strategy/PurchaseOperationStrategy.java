package core.basesyntax.strategy;

import core.basesyntax.fruitstorge.FruitStorage;
import core.basesyntax.fruittransaction.FruitTransaction;

public class PurchaseOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if(fruitTransaction.getAmount() < 0) {
            throw new RuntimeException("Balance is negative.");
        }
        FruitStorage.fruitStorage.merge(fruitTransaction.getName(),
                -fruitTransaction.getAmount(), Integer::sum);
    }
}
