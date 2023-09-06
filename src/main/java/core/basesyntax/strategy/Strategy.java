package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import java.util.Map;

public class Strategy {
    private Map<FruitTransaction.Operation, OperationService> operationStrategies;

    public Strategy(Map<FruitTransaction.Operation, OperationService> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    public void doOperation(FruitTransaction fruitTransaction) {
        operationStrategies.get(fruitTransaction.getOperation())
                .performOperation(fruitTransaction);
    }
}
