package core.basesyntax.model;

import core.basesyntax.dto.Transaction;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;

public enum OperationType {
    PURCHASE("p", new PurchaseOperationHandler()),
    SUPPLY("s", new AddOperationHandler()),
    BALANCE("b", new BalanceOperationHandler()),
    RETURN("r", new AddOperationHandler());

    private final String operationCode;
    private final OperationHandler operationHandler;

    OperationType(String operationCode, OperationHandler operationHandler) {
        this.operationCode = operationCode;
        this.operationHandler = operationHandler;
    }

    public static OperationType getByOperationCode(String operationCode) {
        for (OperationType type : OperationType.values()) {
            if (type.operationCode.equalsIgnoreCase(operationCode)) {
                return type;
            }
        }
        throw new RuntimeException("Invalid operation: " + operationCode);
    }

    public void performOperation(Transaction transaction) {
        operationHandler.handle(transaction);
    }
}
