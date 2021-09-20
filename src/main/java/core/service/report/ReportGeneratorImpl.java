package core.service.report;

import core.controller.FruitShop;
import core.model.Fruit;
import core.model.MyConstants;
import core.service.oparation.OperationHandler;
import core.service.oparation.OperationStrategy;
import core.service.oparation.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final int INDEX_OPERATION_FOR_OPERATION_STRATAGY = 0;
    private Map<String, OperationHandler> operationHandlersMap;

    public ReportGeneratorImpl(Map<String, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public List<String> createReport(List<String> strings) {
        for (String string: strings) {
            String[] tmpStrings = string.split(MyConstants.COMA_SEPARATOR);
            OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
            OperationHandler operationHandler =
                    operationStrategy.get(tmpStrings[INDEX_OPERATION_FOR_OPERATION_STRATAGY]);
            operationHandler.doOperation(FruitShop.FRUITS, tmpStrings);
        }
        List<String> report = new ArrayList<>();
        Map<String, Fruit> fruits = FruitShop.FRUITS;
        for (Map.Entry<String, Fruit> stringFruitEntry : fruits.entrySet()) {
            report.add(stringFruitEntry.getValue().getName()
                    + MyConstants.COMA_SEPARATOR
                    + stringFruitEntry.getValue().getQuantity());
        }
        return report;
    }

}
