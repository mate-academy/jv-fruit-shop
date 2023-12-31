package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.operation_handlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy{
  Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

  public OperationStrategyImpl(
          Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
    this.operationHandlerMap = operationHandlerMap;
  }

  @Override
  public OperationHandler get(FruitTransaction.Operation operation) {
    return operationHandlerMap.get(operation);
  }
}
