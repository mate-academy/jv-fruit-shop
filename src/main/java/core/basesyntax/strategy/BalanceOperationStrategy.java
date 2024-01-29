package core.basesyntax.strategy;

import core.basesyntax.fruitstorge.FruitStorage;
import core.basesyntax.fruittransaction.FruitTransaction;

public class BalanceOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitStorage.fruitStorage.merge(fruitTransaction.getName(),
                fruitTransaction.getAmount(), Integer::sum);
    }
}
