package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransfer;
import core.basesyntax.models.Operation;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    @Override
    public void process(List<FruitTransfer> transferList,
                        Map<Operation, OperationHandler> handlers) {
        for (FruitTransfer lotOfFruit : transferList) {
            OperationHandler chosenStrategy = handlers.get(lotOfFruit.getOperations());
            if (chosenStrategy != null) {
                chosenStrategy.performOperation(lotOfFruit);
            }
        }
    }
}
