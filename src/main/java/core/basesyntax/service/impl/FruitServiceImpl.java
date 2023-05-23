package core.basesyntax.service.impl;

import core.basesyntax.model.fruit.Operation;
import core.basesyntax.model.fruit.Record;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceStrategy;
import core.basesyntax.strategy.impl.PurchaseStrategy;
import core.basesyntax.strategy.impl.ReturnStrategy;
import core.basesyntax.strategy.impl.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<Operation, OperationStrategy> operationMap;
    private Map<String, Integer> fruitMap;

    @Override
    public Map<String, Integer> processRecords(List<Record> records) {
        fillFruitMap(records);
        fillOperationMap();
        for (Record record : records) {
            updateRecord(record);
        }
        return fruitMap;
    }

    private void updateRecord(Record record) {
        String fruitKey = record.getFruit();
        if (fruitMap.containsKey(fruitKey)) {
            int currentQuantity = fruitMap.get(fruitKey);
            int recordQuantity = record.getQuantity();
            int updatedValue = operationMap.get(record.getOperation())
                    .perform(currentQuantity, recordQuantity);
            fruitMap.put(fruitKey, updatedValue);
        }
    }

    private void fillFruitMap(List<Record> records) {
        fruitMap = new HashMap<>();
        for (Record record : records) {
            if (!fruitMap.containsKey(record.getFruit())) {
                fruitMap.put(record.getFruit(), 0);
            }
        }
    }

    private void fillOperationMap() {
        operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceStrategy());
        operationMap.put(Operation.SUPPLY, new SupplyStrategy());
        operationMap.put(Operation.RETURN, new ReturnStrategy());
        operationMap.put(Operation.PURCHASE, new PurchaseStrategy());
    }
}
