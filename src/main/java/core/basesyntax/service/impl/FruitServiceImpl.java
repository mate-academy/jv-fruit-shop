package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.AdditionalStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private AdditionalStrategy additionalStrategy = new AdditionalStrategy();
    private ReductionStrategy reductionStrategy = new ReductionStrategy();
    private Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyAllOperators(List<TransactionDto> transactionDtos) {
        for (int i = 0; i < transactionDtos.size(); i++) {
            switch (transactionDtos.get(i).getOperation()) {
                case BALANCE:
                case SUPPLY:
                case RETURN:
                    additionalStrategy.apply(transactionDtos.get(i));
                    break;
                case PURCHASE:
                default:
                    reductionStrategy.apply(transactionDtos.get(i));
                    break;
            }
        }
    }

    @Override
    public Map<String, Long> getReport() {
        return Storage.fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
    }
}
