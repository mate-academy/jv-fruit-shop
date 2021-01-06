package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, OperationStrategy> allOperations;

    public FruitServiceImpl(Map<Operation, OperationStrategy> allOperations) {
        this.allOperations = allOperations;
    }

    @Override
    public void applyOperations(List<TransactionDto> transactionDtos) {
        for (TransactionDto transaction : transactionDtos) {
            allOperations.get(transaction.getOperation()).apply(transaction);
        }
    }

    @Override
    public Map<String, Long> getReport() {
        Map<String, Long> map = new HashMap<>();
        for (Fruit fruit : Storage.fruits) {
            if (map.containsKey(fruit.getName())) {
                map.put(fruit.getName(), map.get(fruit.getName()) + 1);
            } else {
                map.put(fruit.getName(), 1L);
            }
        }
        return map;
    }
}
