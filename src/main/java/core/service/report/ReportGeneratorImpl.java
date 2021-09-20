package core.service.report;

import core.controller.FruitShop;
import core.model.Fruit;
import core.service.oparation.OperationHandler;
import core.service.oparation.OperationStrategy;
import core.service.oparation.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OPERATION_FOR_OPERATION_STRATEGY = 0;
    private Map<String, OperationHandler> operationHandlersMap;

    public ReportGeneratorImpl(Map<String, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public List<String> createReport(List<String> strings) {
        for (String string : strings) {
            String[] tmpStrings = string.split(COMA_SEPARATOR);
            OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
            OperationHandler operationHandler =
                    operationStrategy.get(tmpStrings[INDEX_OPERATION_FOR_OPERATION_STRATEGY]);
            operationHandler.doOperation(FruitShop.STORAGE.getFruitStorageMap(), tmpStrings);
        }
        List<String> report = new ArrayList<>();
        Map<Fruit, Integer> fruits = FruitShop.STORAGE.getFruitStorageMap();
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : fruits.entrySet()) {
            report.add(fruitIntegerEntry.getKey().getName()
                    + COMA_SEPARATOR
                    + fruitIntegerEntry.getValue());
        }
        return report;
    }

}
