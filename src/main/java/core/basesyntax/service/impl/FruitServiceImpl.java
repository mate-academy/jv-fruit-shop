package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyTransactionsToDB(List<TransactionDto> transactionDtoList) {
        for (TransactionDto transactionDto : transactionDtoList) {
            operationStrategyMap.get(transactionDto.getOperation()).apply(transactionDto);
        }
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.getFruits().entrySet()) {
            stringBuilder.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
