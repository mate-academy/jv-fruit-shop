package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class ShopServiceStrategy {
    private Map<Operation, OperationHandler> opHandlerMap;

    public ShopServiceStrategy(
            Map<Operation, OperationHandler> opHandlerMap) {
        this.opHandlerMap = opHandlerMap;
    }

    public void processTransactions(
            List<FruitTransaction> convertedDataList) {
        Storage.foodStorage.clear();

        convertedDataList.forEach(fruitTransaction -> {
            OperationHandler handler =
                    opHandlerMap.get(fruitTransaction.getOperation());
            if (handler != null) {
                handler.handle(fruitTransaction.getFruitType(), fruitTransaction.getQuantity());
            } else {
                throw new RuntimeException("No handler found for operation: "
                        + fruitTransaction.getOperation());
            }
        });
    }
}
