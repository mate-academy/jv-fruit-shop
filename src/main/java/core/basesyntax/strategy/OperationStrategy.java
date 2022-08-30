package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;

public class OperationStrategy {
    public void operationStrategy(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE:
                new BalanceOperationHandler().handle(transaction);
                break;
            case SUPPLY:
                new SupplyOperationHandler().handle(transaction);
                break;
            case RETURN:
                new ReturnOperationHandler().handle(transaction);
                break;
            case PURCHASE:
                new PurchaseOperationHandler().handle(transaction);
                break;
            default:
                throw new RuntimeException("Incorrect transaction type: "
                        + transaction.getOperation());
        }
    }
}
