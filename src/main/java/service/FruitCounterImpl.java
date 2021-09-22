package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecord;

public class FruitCounterImpl implements FruitCounter {
    private OperationStrategy operationStrategy;

    public FruitCounterImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> countFruit(List<FruitRecord> recordList) {
        Map<String, Integer> fruitValueMap = new HashMap<>();
        String operationType;
        int fruitBalance;
        int amount;
        for (FruitRecord fruitRecord : recordList) {
            operationType = fruitRecord.getOperationType();
            amount = fruitRecord.getAmount();
            if (!fruitValueMap.containsKey(fruitRecord.getFruit())) {
                fruitValueMap.put(fruitRecord.getFruit(), amount);
            } else {
                fruitBalance = fruitValueMap.get(fruitRecord.getFruit());
                fruitBalance = operationStrategy.getOperation(operationType)
                        .apply(fruitBalance, amount);
                fruitValueMap.put(fruitRecord.getFruit(), fruitBalance);
            }
        }
        return fruitValueMap;
    }
}
