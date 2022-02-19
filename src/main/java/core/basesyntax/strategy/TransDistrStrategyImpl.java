package core.basesyntax.strategy;

import core.basesyntax.service.StorageService;
import core.basesyntax.service.TransactionLog;
import java.util.Map;

public class TransDistrStrategyImpl implements TransDistrStrategy {
    private final Map<String, StorageService> operationMap;

    public TransDistrStrategyImpl(Map<String, StorageService> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public StorageService choseStorageService(TransactionLog transactionLog) {
        return operationMap.get(transactionLog.getTypeOfOperation());
    }
}
