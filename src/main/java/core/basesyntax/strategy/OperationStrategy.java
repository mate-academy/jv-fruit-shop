package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;

public class OperationStrategy {
    private static final String BALANCE_NAME = "b";
    private static final String PURCHASE_NAME = "p";
    private static final String RETURN_NAME = "r";
    private static final String SUPPLY_NAME = "s";

    public void implementOperationStrategy(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperationType().getName()) {
            case BALANCE_NAME:
                new BalanceOperation().performOperation(fruitTransaction);
                break;
            case PURCHASE_NAME:
                new PurchaseOperation().performOperation(fruitTransaction);
                break;
            case RETURN_NAME:
                new ReturnOperation().performOperation(fruitTransaction);
                break;
            case SUPPLY_NAME:
                new SupplyOperation().performOperation(fruitTransaction);
                break;
            default:
                throw new RuntimeException("This line is invalid");
        }
    }
}
