package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.FruitShopService;
import core.basesyntax.servise.OperationHandlerStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationHandlerStrategy operationHandlerStrategy;

    public FruitShopServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void apply(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            FruitTransaction.Operation type = fruitTransaction.getOperation();
            operationHandlerStrategy.get(type).process(fruitTransaction);
        }
    }
}
