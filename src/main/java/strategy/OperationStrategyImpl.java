package strategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.handler.BalanceOperationHandler;
import strategy.handler.PurchaseOperationHandler;
import strategy.handler.ReturnOperationHandler;
import strategy.handler.SupplyOperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<FruitTransaction.Operation, OperationHandler> operationHalndlerMap;

    static {
        operationHalndlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation codeOperation) {
        return operationHalndlerMap.get(codeOperation);
    }
}
