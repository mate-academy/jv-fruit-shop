package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class ShopServiceStrategy {
    private Map<Operation, OperationHandler> opHandlerMap;

    public ShopServiceStrategy(Map<Operation, OperationHandler> opHandlerMap) {
        this.opHandlerMap = opHandlerMap;
    }

    public OperationHandler get(Operation type) {
        return opHandlerMap.get(type);
    }

    public void processDataFromObj(List<CsvConverter.OperationData> convertedDataList) {
        StorageDaoImpl.clear();

        convertedDataList
                .forEach(operationData -> {
                    OperationHandler handler =
                            opHandlerMap.get(Operation.getByCode(operationData.operation()));
                    if (handler != null) {
                        handler.handle(operationData.fruitType(), operationData.quantity());
                    } else {
                        System.out.println("No handler found for operation: " + operationData.operation());
                    }
                });
    }
}
