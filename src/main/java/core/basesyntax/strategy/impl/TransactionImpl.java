package core.basesyntax.strategy.impl;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.Transaction;
import java.util.List;
import java.util.Map;

public class TransactionImpl implements Transaction {
    private static final Integer UPPER_BOUND = 1000;
    private final OperationStrategy operationStrategy;

    public TransactionImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitsTranslation> transactions) {
        return transactions.stream()
                .map(t -> operationStrategy.get(t.getOperation())
                        .getOperationResult(t))
                .collect(groupingBy(FruitsTranslation::getFruit,
                        filtering(fruitTransaction -> fruitTransaction.getQuantity() < UPPER_BOUND,
                                summingInt(FruitsTranslation::getQuantity))));
    }
}

