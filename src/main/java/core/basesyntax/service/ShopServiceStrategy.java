package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

        convertedDataList.forEach(operationData -> {
            if (Objects.equals(operationData.operation(), Operation.BALANCE.getCode())) {
                get(Operation.BALANCE).handle(operationData.fruitType(), operationData.quantity());
            }

            if (Objects.equals(operationData.operation(), Operation.PURCHASE.getCode())) {
                get(Operation.PURCHASE).handle(operationData.fruitType(), operationData.quantity());
            }

            if (Objects.equals(operationData.operation(), Operation.SUPPLY.getCode())) {
                get(Operation.SUPPLY).handle(operationData.fruitType(), operationData.quantity());
            }

            if (Objects.equals(operationData.operation(), Operation.RETURN.getCode())) {
                get(Operation.RETURN).handle(operationData.fruitType(), operationData.quantity());
            }
        });
    }
}
