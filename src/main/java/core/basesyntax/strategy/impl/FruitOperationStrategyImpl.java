package core.basesyntax.strategy.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.FruitOperationStrategy;
import core.basesyntax.strategy.OperationHandler;

import java.util.List;
import java.util.Map;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    private Map<Operation, OperationHandler> handlerOperationMap;
    private final StorageDao storageDao = new StorageDaoImpl();

    public FruitOperationStrategyImpl(Map<Operation, OperationHandler> handlerOperationMap) {
        this.handlerOperationMap = handlerOperationMap;
    }

    @Override
    public void countFruits(List<FruitTransaction> fruitTransactions) {
        List<String> fruitNames = fruitTransactions.stream()
                .map(FruitTransaction::getFruitName)
                .distinct()
                .toList();

        for (String fruitName : fruitNames) {
            long fruitCount = 0;
            for (Map.Entry<Operation, OperationHandler> entry : handlerOperationMap.entrySet()) {
                fruitCount += entry.getValue().count(fruitTransactions, fruitName);
            }

            storageDao.add(fruitName, fruitCount);
        }
    }
}
