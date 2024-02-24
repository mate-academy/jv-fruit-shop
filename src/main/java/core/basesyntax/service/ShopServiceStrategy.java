package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class ShopServiceStrategy {
    private Map<Operation, OperationHandler> opHandlerMap;

    public ShopServiceStrategy(Map<Operation, OperationHandler> opHandlerMap) {
        this.opHandlerMap = opHandlerMap;
    }

    public void processTransactions(
            List<TransactionConverterImpl.FruitTransaction> convertedDataList) {
        Storage.foodStorage.clear();

        convertedDataList.forEach(fruitTransaction -> {
            OperationHandler handler =
                    opHandlerMap.get(Operation.getByCode(fruitTransaction.operation()));
            if (handler != null) {
                handler.handle(fruitTransaction.fruitType(), fruitTransaction.quantity());
            } else {
                System.out.println("No handler found for operation: "
                        + fruitTransaction.operation());
            }
        });
    }
}
