package strategy;

import java.util.Map;
import model.FruitTransaction;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> fruitTransactionMap;

    public FruitTransactionStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                                fruitTransactionMap) {
        this.fruitTransactionMap = fruitTransactionMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return fruitTransactionMap.get(operation);
    }
}
