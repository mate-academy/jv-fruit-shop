package core.basesyntax.strategy;

import core.basesyntax.service.OperationService;
import core.basesyntax.service.impl.Balance;
import core.basesyntax.service.impl.Purchase;
import core.basesyntax.service.impl.Return;
import core.basesyntax.service.impl.Supply;

public enum OperationType {
    BALANCE("b", new Balance()),
    PURCHASE("p", new Purchase()),
    RETURN("r", new Return()),
    SUPPLY("s", new Supply())
    ;

    private final OperationService operationType;
    private final String name;

    OperationType(String name, OperationService operation) {
        this.name = name;
        this.operationType = operation;
    }

    public OperationService getOperationType() {
        return operationType;
    }

    public String getName() {
        return name;
    }
}
