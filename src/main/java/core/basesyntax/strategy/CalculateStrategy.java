package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationHandlerBalance;
import core.basesyntax.service.OperationHandlerIn;
import core.basesyntax.service.OperationHandlerOut;
import java.util.HashMap;
import java.util.Map;

public class CalculateStrategy {

    public void calculate(FruitTransaction fruitTransaction,
                              FruitTransaction.Operation operation) {
        Map<FruitTransaction.Operation, OperationHandler> correspondenceTable = new HashMap<>() {{
                put(FruitTransaction.Operation.BALANCE, new OperationHandlerBalance());
                put(FruitTransaction.Operation.SUPPLY, new OperationHandlerIn());
                put(FruitTransaction.Operation.RETURN, new OperationHandlerIn());
                put(FruitTransaction.Operation.PURCHASE, new OperationHandlerOut());
            }};
        OperationHandler handler = correspondenceTable.get(operation);
        handler.handle(fruitTransaction);
    }
}
