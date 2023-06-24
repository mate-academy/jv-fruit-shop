package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitReport;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;
import core.basesyntax.strategy.CreatorStrategyMap;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {

    @Override
    public List<FruitReport> prepareDataForReport(List<FruitTransaction> readFromFile) {
        OperationStrategy operationStrategy =
                new OperationStrategy(new CreatorStrategyMap().getOperationStrategyMap());
        for (FruitTransaction element : readFromFile) {
            operationStrategy.getOperationHandler(element.getOperation())
                    .process(element);
        }
        return Storage.fruits.entrySet()
                .stream()
                .map(f -> new FruitReport(f.getKey(),f.getValue()))
                .collect(Collectors.toList());
    }
}
