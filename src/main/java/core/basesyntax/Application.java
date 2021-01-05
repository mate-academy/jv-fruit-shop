package core.basesyntax;

import core.basesyntax.service.Procedure;
import core.basesyntax.service.ReportWorker;
import core.basesyntax.service.fileworker.InputOutputReport;
import core.basesyntax.strategy.Balance;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.Purchase;
import core.basesyntax.strategy.Return;
import core.basesyntax.strategy.Supply;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Procedure, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Procedure.Balance, new Balance());
        operationStrategyMap.put(Procedure.Purchase, new Purchase());
        operationStrategyMap.put(Procedure.Return, new Return());
        operationStrategyMap.put(Procedure.Supply, new Supply());
        InputOutputReport inputOutputReport = new InputOutputReport();
        String report = inputOutputReport.readReport("reportIn");
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport(report, operationStrategyMap);
        inputOutputReport.writeReport(reportWorker.writeToReport(), LocalDate.now().toString());

    }
}



