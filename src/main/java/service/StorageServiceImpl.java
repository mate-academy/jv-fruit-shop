package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecord;

public class StorageServiceImpl implements StorageService {
    private OperationStrategy operationStrategy;

    public StorageServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processingData(List<FruitRecord> recordList) {
        Map<String, Integer> fruitValueMap = new HashMap<>();
        String operationType;
        int fruitAmountInStorage;
        int newAmountOfFruit;
        int amount;
        for (FruitRecord fruitRecord : recordList) {
            operationType = fruitRecord.getOperationType();
            amount = fruitRecord.getAmount();
            if (!fruitValueMap.containsKey(fruitRecord.getFruit())) {
                fruitValueMap.put(fruitRecord.getFruit(), amount);
            } else {
                fruitAmountInStorage = fruitValueMap.get(fruitRecord.getFruit());
                newAmountOfFruit = operationStrategy.getOperation(operationType)
                        .changeFruitAmount(fruitAmountInStorage, amount);
                fruitValueMap.put(fruitRecord.getFruit(), newAmountOfFruit);
            }
        }
        return fruitValueMap;
    }
}
