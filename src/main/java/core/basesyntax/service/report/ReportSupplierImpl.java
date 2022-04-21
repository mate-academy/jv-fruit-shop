package core.basesyntax.service.report;

import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.List;

public class ReportSupplierImpl implements ReportSupplier {
    @Override
    public String getReport(List<String> records) {
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        records.remove(0);
        for (String record : records) {
            operationStrategy.get(splitString(record)[0])
                    .doOperation(splitString(record)[1],
                            Integer.parseInt(splitString(record)[2]));
        }
        ReportService reportService = new ReportServiceImpl();
        return reportService.createReport();
    }

    private static String[] splitString(String string) {
        return string.split(",");
    }
}
