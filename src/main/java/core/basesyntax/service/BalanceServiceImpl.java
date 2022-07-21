package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceServiceImpl implements BalanceService {
    private final OperationStrategy operationStrategy;

    public BalanceServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<Fruit> process(List<Transaction> transactions) {
        transactions.forEach(t -> operationStrategy.get(t.getOperation()).handle(t));
        Map<Fruit, Integer> result = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getProduct)).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .mapToInt(Transaction::getQuantity)
                                .sum()));
        result.forEach(Fruit::setQuantity);
        return new ArrayList<>(result.keySet());
    }
}
