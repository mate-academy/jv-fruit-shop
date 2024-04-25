package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitCalculator;
import strategy.impl.FruitOperationHandler;

public class FruitCalculatorImpl implements FruitCalculator {
    private final Map<String, Integer> fruitUniqueMap = new HashMap<>();
    private final FruitOperationHandler operationHandler;
    private FruitDao fruitDao;

    public FruitCalculatorImpl() {
        operationHandler = new FruitOperationHandler();
        fruitDao = new FruitDaoImpl();
    }

    public void calculateFruit(List<FruitTransaction> listFruitTransaction) {
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
        listCountedFruit.entrySet().stream()
                .forEach(entry -> fruitDao.put(entry.getKey(), entry.getValue()));
    }
}
