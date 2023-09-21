package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.impl.OperationHandlerBalance;
import core.basesyntax.service.impl.OperationHandlerIn;
import core.basesyntax.service.impl.OperationHandlerOut;
import java.util.Map;

public class CalculateStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> correspondenceTable = Map.of(
            FruitTransaction.Operation.BALANCE, new OperationHandlerBalance(),
            FruitTransaction.Operation.SUPPLY, new OperationHandlerIn(),
            FruitTransaction.Operation.RETURN, new OperationHandlerIn(),
            FruitTransaction.Operation.PURCHASE, new OperationHandlerOut());

    public void calculate(FruitTransaction fruitTransaction,
                              FruitTransaction.Operation operation) {
        OperationHandler handler = correspondenceTable.get(operation);
        handler.handle(fruitTransaction);
    }
}
