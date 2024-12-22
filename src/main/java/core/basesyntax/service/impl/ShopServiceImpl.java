package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransfer;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransfer> transferList) {
        for (FruitTransfer lotOfFruit : transferList) {
            OperationHandler chosenHandler = operationStrategy.getStrategy(lotOfFruit);
            if (chosenHandler != null) {
                chosenHandler.performOperation(lotOfFruit);
            }
        }
    }
}
