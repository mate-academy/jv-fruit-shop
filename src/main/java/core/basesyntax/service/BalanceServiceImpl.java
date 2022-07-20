package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.*;
import java.util.stream.Collectors;

public class BalanceServiceImpl implements BalanceService {
    private final OperationStrategy operationStrategy;

    public BalanceServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<Fruit> calculateBalance(List<Transaction> transactionsFromFile) {
        Map<Fruit, Integer> fruitIntegerMap = transactionsFromFile.stream()
                .collect(Collectors.groupingBy(Transaction::getProduct)).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .mapToInt(v -> operationStrategy
                                        .get(v.getOperation())
                                        .getOperationalQuantity(v.getQuantity()))
                                .sum()));
        fruitIntegerMap.forEach(Fruit::setQuantity);
        return new ArrayList<>(fruitIntegerMap.keySet());
    }
}
