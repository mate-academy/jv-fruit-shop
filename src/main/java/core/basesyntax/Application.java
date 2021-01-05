package core.basesyntax;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.fruitoperation.strategy.OperationStrategyImpl;
import core.basesyntax.report.ReportFormatter;
import core.basesyntax.report.ReportFormatterImpl;
import core.basesyntax.workwithfiles.impl.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new OperationBalance());
        operationMap.put(Operations.P, new OperationPurchase());
        operationMap.put(Operations.R, new OperationReturn());
        operationMap.put(Operations.S, new OperationSupply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        ReportFormatter reportFormatter = new ReportFormatterImpl(operationStrategy);
        System.out.println(reportFormatter.createReport(
                new FileReader("src/main/resources/test1_correct.csv")));
    }
}
