package core.basesyntax.service.impl;

import core.basesyntax.model.FruitReport;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {
    private final Map<String, Integer> storage = new HashMap<>();

    @Override
    public List<FruitReport> dataforReport(List<FruitTransaction> readFromFile) {
        OperationStrategy operationStrategy = new OperationStrategy();
        for (FruitTransaction element : readFromFile) {
            operationStrategy.getOperationHandler(element.getOperation())
                    .process(element.getFruit(), element.getQuantity(), storage);
        }
        return storage.entrySet()
                .stream()
                .map(f -> new FruitReport(f.getKey(),f.getValue()))
                .collect(Collectors.toList());
    }
}
