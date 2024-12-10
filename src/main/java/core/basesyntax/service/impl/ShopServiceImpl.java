package core.basesyntax.service.impl;

import core.basesyntax.FruitTransfer;
import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;
import core.basesyntax.service.ShopService;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    @Override
    public void process(List<FruitTransfer> transferList,
                        Map<Operation, OperationHandler> handlers) {
        for (FruitTransfer lotOfFruit : transferList) {
            OperationHandler chosenStrategy = handlers.get(lotOfFruit.getOperations());
            if (chosenStrategy != null) {
                chosenStrategy.setFruitTransfer(lotOfFruit);
                chosenStrategy.makeOperation();
            }
        }
    }
}
