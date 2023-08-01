package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationHandlerFactory;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationHandlerFactory operationHandlerFactory = new OperationHandlerFactory();

    @Override
    public void processAll(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            process(fruitTransaction);
        }
    }

    private void process(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler = operationHandlerFactory.get(fruitTransaction);
        operationHandler.operate(fruitTransaction);
    }
}
