package core.basesyntax.transactionprocessorimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionprocessor.OperationHandler;
import core.basesyntax.transactionprocessor.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler getImplementation(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE:
                return new BalanceHandler();
            case SUPPLY:
                return new SupplyHandler();
            case PURCHASE:
                return new PurchaseHandler();
            case RETURN:
                return new ReturnHandler();
            default:
                throw new RuntimeException("There is no such Operation: "
                        + transaction.getOperation());
        }
    }
}
