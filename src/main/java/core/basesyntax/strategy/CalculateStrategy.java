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

    public void calculate(FruitTransaction fruitTransaction,
                          FruitTransaction.Operation operation) {
        OperationHandler handler = correspondenceTable.get(operation);
        handler.handle(fruitTransaction);
    }
}
