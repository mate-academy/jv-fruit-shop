package servise.strategy;

import java.util.Map;
import model.FruitTransaction;
import operation.OperationHandler;

public class StrategyOperationImpl implements StrategyOperation {
    private Map<String, OperationHandler> map;

    public StrategyOperationImpl(Map<String, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction fruitTransaction) {
        return map.get(fruitTransaction.getOperation());
    }
}
