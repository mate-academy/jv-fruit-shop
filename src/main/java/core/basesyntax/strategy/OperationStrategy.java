package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);

    class OperationStrategyImpl implements OperationStrategy {
        private Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap;

        public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                             operationHandlersMap) {
            this.operationHandlersMap = operationHandlersMap;
        }

        @Override
        public OperationHandler get(FruitTransaction.Operation operation) {
            return operationHandlersMap.get(operation);
        }
    }
}
