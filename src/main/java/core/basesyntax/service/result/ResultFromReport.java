package core.basesyntax.service.result;

import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ResultFromReport {
    void getResultFromReport(List<FruitTransaction> fruitTransactionList,
                             Map<String, Integer> fruitTypesAndQuantity,
                             Map<String, OperationType> operationStrategyMap);
}
