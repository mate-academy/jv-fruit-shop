package core.basesyntax.impl;

import core.basesyntax.database.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitshopService;
import core.basesyntax.service.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitshopServiceImpl implements FruitshopService {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public FruitshopServiceImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction value : fruitTransactionList) {
            if (operationHandlerMap.get(value.getOperation()) == null) {
                throw new RuntimeException("Invalid operation type");
            }
            operationHandlerMap
                    .get(value.getOperation())
                    .apply(value.getFruit(), value.getQuantity());
        }
    }
}
