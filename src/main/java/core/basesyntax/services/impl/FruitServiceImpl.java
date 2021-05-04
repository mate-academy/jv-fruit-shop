package core.basesyntax.services.impl;

import core.basesyntax.db.FruitDataBase;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.services.FruitService;
import core.basesyntax.strategy.FruitStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, FruitStrategy> fruitStrategyMap;

    public FruitServiceImpl(Map<Operation, FruitStrategy> fruitStrategyMap) {
        this.fruitStrategyMap = fruitStrategyMap;
    }

    @Override
    public void applyOperation(List<TransactionDto> transactionDtos) {
        for (TransactionDto transactionDto : transactionDtos) {
            fruitStrategyMap.get(transactionDto.getOperation()).change(transactionDto);
        }
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : FruitDataBase.getFruitMap().entrySet()) {
            report.append(entry.getKey().getName())
                    .append(", ")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
