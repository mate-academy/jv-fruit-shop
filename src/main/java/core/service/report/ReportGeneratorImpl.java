package core.service.report;

import core.model.Fruit;
import core.model.MyConstants;
import core.service.oparation.OperationHandler;
import core.service.oparation.OperationStrategy;
import core.service.oparation.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.HashMap;
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
        Fruit banana = new Fruit("banana");
        Fruit apple = new Fruit("apple");
        Map<String, Fruit> fruitMap = new HashMap<>();
        fruitMap.put(MyConstants.BANANA, banana);
        fruitMap.put(MyConstants.APPLE, apple);
        for (String string: strings) {
            String[] tmpStrings = string.split(MyConstants.COMA_SEPARATOR);
            OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
            OperationHandler operationHandler =
                    operationStrategy.get(tmpStrings[INDEX_OPERATION_FOR_OPERATION_STRATAGY]);
            operationHandler.doOperation(fruitMap, tmpStrings);
        }
        List<String> report = new ArrayList<>();
        String bananaToString = banana.getName()
                + MyConstants.COMA_SEPARATOR + banana.getQuantity();
        String appleToString = apple.getName()
                + MyConstants.COMA_SEPARATOR + apple.getQuantity();
        report.add(bananaToString);
        report.add(appleToString);
        return report;
    }
}
