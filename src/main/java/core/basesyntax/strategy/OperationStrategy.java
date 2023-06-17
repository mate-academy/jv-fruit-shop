package core.basesyntax.strategy;

import core.basesyntax.strategy.operations.BalanceOperation;
import core.basesyntax.strategy.operations.PurchaseOperation;
import core.basesyntax.strategy.operations.ReturnOperation;
import core.basesyntax.strategy.operations.SupplyOperation;

public class OperationStrategy {
    private static final Operation BALANCE = new BalanceOperation();
    private static final Operation PURCHASE = new PurchaseOperation();
    private static final Operation SUPPLY = new SupplyOperation();
    private static final Operation RETURN = new ReturnOperation();

    public static Operation getOperations(String operation) {

        if (Operations.BALANCE.getOperation().equals(operation)) {
            return BALANCE;
        }
        if (Operations.PURCHASE.getOperation().equals(operation)) {
            return PURCHASE;
        }
        if (Operations.SUPPLY.getOperation().equals(operation)) {
            return SUPPLY;
        }
        if (Operations.RETURN.getOperation().equals(operation)) {
            return RETURN;
        }
        throw new RuntimeException("The type of operation is wrong");
    }
}
