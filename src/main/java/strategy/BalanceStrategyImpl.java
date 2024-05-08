package strategy;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import strategy.operation.BalanceOperationHandler;
import strategy.operation.OperationHandler;
import strategy.operation.PurchaseOperationHandler;
import strategy.operation.ReturnOperationHandler;
import strategy.operation.SupplyOperationHandler;

public class BalanceStrategyImpl implements OperationStrategy {
    private final Map<String, Integer> fruitBalance = new HashMap<>();
    private final Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap = new HashMap<>();

    @Override
    public OperationHandler handler(FruitTransaction fruitTransaction) {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseOperationHandler());
        return operationHandlerMap.get(fruitTransaction.getOperation());
    }

    @Override
    public Map<String, Integer> getFruitStatistic() {
        return fruitBalance;
    }

    @Override
    public void executeStrategy(FruitTransaction fruitTransaction) {
        handler(fruitTransaction).execute(fruitBalance, fruitTransaction);
    }
}
