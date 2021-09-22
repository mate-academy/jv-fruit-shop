package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.OperationType;
import core.basesyntax.fruitshop.model.TransactionDto;
import core.basesyntax.fruitshop.service.operation.OperationHandler;
import core.basesyntax.fruitshop.storage.Storage;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final Map<OperationType, OperationHandler> operationHandlerMap;

    public FruitShopServiceImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.fruitBalance.entrySet()) {
            stringBuilder.append(System.lineSeparator()).append(entry.getKey()).append(",")
                    .append(entry.getValue());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    @Override
    public void applyOperationsOnTransactionDto(List<TransactionDto> dtoList) {
        for (TransactionDto transaction: dtoList) {
            OperationHandler operationHandler = operationHandlerMap
                    .get(transaction.getOperationType());
            operationHandler.applyOperation(transaction);
        }
    }
}
