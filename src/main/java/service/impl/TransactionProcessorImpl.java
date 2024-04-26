package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.TransactionProcessor;
import strategy.impl.FruitOperationHandler;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final FruitOperationHandler operationHandler;
    private final FruitDao fruitDao;

    public TransactionProcessorImpl() {
        operationHandler = new FruitOperationHandler();
        fruitDao = new FruitDaoImpl();
    }

    public void processTransactions(List<FruitTransaction> listFruitTransaction) {
        Map<String, Integer> fruitUniqueMap = new HashMap<>();
        for (FruitTransaction fruitTransaction : listFruitTransaction) {
            Integer newValue = operationHandler.executeOperation(
                    fruitTransaction.getOperationType(),
                    fruitUniqueMap.getOrDefault(fruitTransaction.getFruitType(), 0),
                    fruitTransaction.getValue()
            );
            fruitUniqueMap.put(fruitTransaction.getFruitType(), newValue);
            fruitTransaction.setValue(newValue);
        }
        writeToDataBase(fruitUniqueMap);
    }

    public void writeToDataBase(Map<String, Integer> listCountedFruit) {
        for (Map.Entry<String, Integer> entry : listCountedFruit.entrySet()) {
            String fruitType = entry.getKey();
            Integer count = entry.getValue();

            if (fruitDao.containsKey((fruitType))) {
                fruitDao.put(fruitType, count + Storage.fruitHashMap.get(fruitType));
            } else {
                fruitDao.put(fruitType, count);
            }
        }
    }
}
