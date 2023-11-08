package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final Map<FruitTransaction.Operation, OperationHandler> strategyMap;

    public FruitShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void processAll(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            process(fruitTransaction);
        }
    }

    private void process(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler = strategyMap.get(fruitTransaction.getOperation());
        operationHandler.operate(fruitTransaction);
    }
}
