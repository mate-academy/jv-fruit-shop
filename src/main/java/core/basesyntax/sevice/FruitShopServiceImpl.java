package core.basesyntax.sevice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void doFruitShopOperation(List<FruitTransaction> list) {
        for (FruitTransaction fruitTransaction : list) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .operationProcess(fruitTransaction);
        }
    }
}
