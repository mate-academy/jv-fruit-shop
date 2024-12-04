package service.impl;

import core.basesyntax.FruitTransfer;
import core.basesyntax.OperationStrategy;
import core.basesyntax.Operations;
import java.util.List;
import java.util.Map;
import service.ShopService;

public class ShopServiceImpl implements ShopService {
    private Map<Operations, OperationStrategy> handlers;

    public ShopServiceImpl(Map<Operations, OperationStrategy> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void process(List<FruitTransfer> transferList) {
        for (FruitTransfer lotOfFruit : transferList) {
            OperationStrategy chosenStrategy = handlers.get(lotOfFruit.getOperations());
            if (chosenStrategy != null) {
                chosenStrategy.setFruitTransfer(lotOfFruit);
                chosenStrategy.makeOperation();
            }
        }
    }
}
