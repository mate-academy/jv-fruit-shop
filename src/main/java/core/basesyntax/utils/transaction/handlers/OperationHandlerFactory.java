package core.basesyntax.utils.transaction.handlers;

import core.basesyntax.utils.transaction.FruitTransaction;
import core.basesyntax.utils.transaction.handlers.impl.BalanceOperation;
import core.basesyntax.utils.transaction.handlers.impl.PurchaseOperation;
import core.basesyntax.utils.transaction.handlers.impl.ReturnOperation;
import core.basesyntax.utils.transaction.handlers.impl.SupplyOperation;

public class OperationHandlerFactory {
    public OperationHandler getOperationHandlerFromOperation(FruitTransaction.Operation operation) {
        return switch (operation) {
            case BALANCE -> new BalanceOperation();
            case PURCHASE -> new PurchaseOperation();
            case RETURN -> new ReturnOperation();
            case SUPPLY -> new SupplyOperation();
        };
    }
}
