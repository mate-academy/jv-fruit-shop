package core.basesyntax.service.report;

import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ReportService {
    void countFruit(List<FruitTransaction> fruitTransactionList,
                    Map<String, Integer> fruitTypesAndQuantity,
                    Map<String, OperationType> operationStrategyMap);
}
