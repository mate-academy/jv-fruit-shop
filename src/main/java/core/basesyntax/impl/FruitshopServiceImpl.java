package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitshopService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitshopServiceImpl implements FruitshopService, OperationStrategy {
    private final Map<DataBase.Operation, OperationHandler> operationHandlerMap;

    public FruitshopServiceImpl(Map<DataBase.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactionList,
                            Map<DataBase.Operation, OperationHandler> operationHandlerMap) {
        for (FruitTransaction value : fruitTransactionList) {
            getHandler(value).apply(value.getFruit(), value.getQuantity());
        }
    }

    @Override
    public OperationHandler getHandler(FruitTransaction fruitTransaction) {
        var checkHandlerForNull = fruitTransaction.getOperation();
        if (checkHandlerForNull == null) {
            throw new RuntimeException("Invalid operation type. "
                    + "Choose operation type correctly");
        }
        return operationHandlerMap.get(fruitTransaction.getOperation());
    }
}
