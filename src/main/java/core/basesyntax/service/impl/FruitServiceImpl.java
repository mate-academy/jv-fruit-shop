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
    private Map<Operation, OperationStrategy> operations;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operations) {
        this.operations = operations;
    }

    @Override
    public Map<String, Integer> getFruitReport() {
        Map<String, Integer> fruitReport = new HashMap<>();
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruitsStorage().entrySet()) {
            fruitReport.put(entry.getKey().getName(), entry.getValue());
        }
        return fruitReport;
    }

    public void applyOperationOnFruitDto(List<TransactionDto> transactionsDto) {
        for (TransactionDto transaction : transactionsDto) {
            operations.get(transaction.getOperation()).apply(transaction);
        }

    }
}
