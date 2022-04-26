package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.BalanceOperationHandlerImpl;
import core.basesyntax.service.operation.PurchaseOperationHandlerImpl;
import core.basesyntax.service.operation.ReturnOperationHandlerImpl;
import core.basesyntax.service.operation.SupplyOperationHandlerImpl;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    @Override
    public void typeOperation(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperation()) {
            case BALANCE:
                new BalanceOperationHandlerImpl().operation(fruitTransaction);
                break;
            case SUPPLY:
                new SupplyOperationHandlerImpl().operation(fruitTransaction);
                break;
            case PURCHASE:
                new PurchaseOperationHandlerImpl().operation(fruitTransaction);
                break;
            case RETURN:
                new ReturnOperationHandlerImpl().operation(fruitTransaction);
                break;
            default:
                throw new RuntimeException("Can't find operation: FruitTransactionStrategyImpl");
        }
    }
}
