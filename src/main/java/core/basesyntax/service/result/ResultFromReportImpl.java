package core.basesyntax.service.result;

import core.basesyntax.models.Fruit;
import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.strategy.CountStrategy;
import core.basesyntax.service.strategy.CountStrategyImpl;
import java.util.List;
import java.util.Map;

public class ResultFromReportImpl implements ResultFromReport {

    @Override
    public void getResultFromReport(List<String> dataFromReport, Map<String,
            OperationType> operationStrategyMap, Map<Fruit, Integer> dataToUpdateReport,
                                    Map<String, Fruit> fruitTypes) {
        CountStrategy countStrategy = new CountStrategyImpl();
        for (int i = 1; i < dataFromReport.size(); i++) {
            countStrategy.getOperationType(operationStrategyMap, dataFromReport.get(i))
                    .countFruits(dataToUpdateReport, fruitTypes, dataFromReport.get(i));
        }
    }
}
