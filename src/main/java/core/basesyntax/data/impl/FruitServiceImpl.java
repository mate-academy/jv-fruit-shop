package core.basesyntax.data.impl;

import core.basesyntax.data.FruitService;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.storage.FruitDataBase;
import core.basesyntax.strategy.FruitsStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, FruitsStrategy> fruitStrategies;

    public FruitServiceImpl(Map<Operation, FruitsStrategy> fruitStrategies) {
        this.fruitStrategies = fruitStrategies;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<TransactionDto> transactionDtos) {
        for (TransactionDto transaction : transactionDtos) {
            fruitStrategies.get(transaction.getOperation()).change(transaction);
        }
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entrySet : FruitDataBase.getFruitData().entrySet()) {
            report.append(entrySet.getKey().getName()).append(", ").append(entrySet.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
