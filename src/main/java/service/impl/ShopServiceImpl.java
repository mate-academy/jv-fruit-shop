package service.impl;

import core.basesyntax.FruitTransfer;
import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;
import java.util.List;
import java.util.Map;
import service.ShopService;

public class ShopServiceImpl implements ShopService {
    private Map<Operation, OperationHandler> handlers;

    public ShopServiceImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void process(List<FruitTransfer> transferList) {
        for (FruitTransfer lotOfFruit : transferList) {
            OperationHandler chosenStrategy = handlers.get(lotOfFruit.getOperations());
            if (chosenStrategy != null) {
                chosenStrategy.setFruitTransfer(lotOfFruit);
                chosenStrategy.makeOperation();
            }
        }
    }
}
