package core.basesyntax.service.report;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    private OperationStrategy operationStrategy;

    public FruitReportServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Fruit> handleAll(List<FruitTransaction> fruits) {
        for (FruitTransaction fruit : fruits) {
            operationStrategy.get(fruit.getOperation()).handle(fruit);
        }
        return Storage.fruits;
    }
}
