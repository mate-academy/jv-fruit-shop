package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class CalculateStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> correspondenceTable;

    public CalculateStrategy(Map<FruitTransaction.Operation,
            OperationHandler> correspondenceTable) {
        this.correspondenceTable = correspondenceTable;
    }

    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return correspondenceTable.get(operation);
    }
}
