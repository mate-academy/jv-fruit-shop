package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.FruitOperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final ParserImpl parser = new ParserImpl();
    private final Map<Operation, FruitOperationStrategy> strategyMap;

    public FruitServiceImpl(Map<Operation, FruitOperationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void fillStorage(List<String> transactions) {
        FruitOperationStrategy strategy;
        for (String transaction : transactions) {
            FruitTransaction parsedTransaction = parser.parse(transaction);
            strategy = strategyMap.get(parsedTransaction.getOperation());
            strategy.apply(parsedTransaction);
        }
    }
}
