package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<Operation, OperationStrategy> strategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public Map<Operation, OperationStrategy> getStrategyMap() {
        return strategyMap;
    }

    @Override
    public void processActivities(List<TransactionDto> incomeAlgorithm) {
        for (TransactionDto dto : incomeAlgorithm) {
            strategyMap.get(dto.getOperation()).apply(dto);
        }
    }

    @Override
    public Map<Fruit, Integer> getReport() {
        return Storage.storage;
    }
}
