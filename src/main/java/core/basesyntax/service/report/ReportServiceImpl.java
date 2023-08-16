package core.basesyntax.service.report;

import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.strategy.CountStrategy;
import core.basesyntax.service.strategy.CountStrategyImpl;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private CountStrategy countStrategy = new CountStrategyImpl();

    @Override
    public void countFruit(List<FruitTransaction> fruitTransactionList,
                           Map<String, Integer> fruitTypesAndQuantity,
                           Map<String, OperationType> operationStrategyMap) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            countStrategy.getOperationType(operationStrategyMap, fruitTransaction)
                    .makeOperationWithFruit(fruitTransaction);
        }
    }
}
