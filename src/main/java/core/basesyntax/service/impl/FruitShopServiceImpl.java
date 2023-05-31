package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {

    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy optionalStrategy) {
        this.operationStrategy = optionalStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .operate(fruitTransaction);
        }
    }
}
