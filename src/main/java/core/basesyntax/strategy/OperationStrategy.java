package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;

public class OperationStrategy {
    public void implementOperationStrategy(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperationType().getName()) {
            case "b":
                new BalanceOperation().performOperation(fruitTransaction);
                break;
            case "p":
                new PurchaseOperation().performOperation(fruitTransaction);
                break;
            case "r":
                new ReturnOperation().performOperation(fruitTransaction);
                break;
            case "s":
                new SupplyOperation().performOperation(fruitTransaction);
                break;
            default:
                throw new RuntimeException("This line is invalid");
        }
    }

}
