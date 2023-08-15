package core.basesyntax.service.result;

import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.strategy.CountStrategy;
import core.basesyntax.service.strategy.CountStrategyImpl;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public class ResultFromReportImpl implements ResultFromReport {
    private CountStrategy countStrategy = new CountStrategyImpl();

    @Override
    public void getResultFromReport(List<FruitTransaction> fruitTransactionList,
                                    Map<String, Integer> fruitTypesAndQuantity,
                                    Map<String, OperationType> operationStrategyMap) {
        for (int i = 0; i < fruitTransactionList.size(); i++) {
            countStrategy.getOperationType(operationStrategyMap, fruitTransactionList.get(i))
                    .countFruits(fruitTypesAndQuantity, fruitTransactionList.get(i));
        }
    }
}
