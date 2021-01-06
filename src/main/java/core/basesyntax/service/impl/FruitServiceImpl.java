package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationWithFruits;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<Operations, OperationWithFruits> operationMap;

    public FruitServiceImpl(Map<Operations, OperationWithFruits> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void putDataToStorage(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            operationMap.get(transaction.getOperation()).apply(transaction);
        }
    }

    @Override
    public Map<Fruit, Integer> getDataFromStorage() {
        return Storage.storage;
    }
}
