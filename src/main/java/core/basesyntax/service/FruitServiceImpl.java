package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, OperationStrategy> operations;

    public FruitServiceImpl(final Map<Operation,
            OperationStrategy> operations) {
        this.operations = operations;
    }

    @Override
    public String generateReport(final List<FruitTransaction> transactions) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        stringBuilder.append(System.lineSeparator());
        String result = transactions
                .stream()
                .collect(Collectors.groupingBy(
                                FruitTransaction::getFruit,
                                Collectors.summingInt(
                                        e -> operations.get(
                                                e.getOperation()).calculate(e.getQuantity()))
                        ))
                .entrySet()
                .stream()
                .map(e -> e.getKey() + "," + e.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        stringBuilder.append(result);
        return stringBuilder.toString();
    }
}
