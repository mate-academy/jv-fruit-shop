package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopTransferService;
import core.basesyntax.service.operationhandler.Operation;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopTransferServiceImpl implements FruitShopTransferService {

    public void updateStorageInfo(List<FruitTransaction> fruitStorages,
                                         Map<Operation, OperationHandler> operationType) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationType);
        for (FruitTransaction fruitTransaction : fruitStorages) {
            operationStrategy
                    .get(fruitTransaction.getOperation()).getOperation(fruitTransaction);
        }
    }
}
