package core.basesyntax;

import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.CsvDataReaderServiceImpl;
import core.basesyntax.service.impl.CsvDataWriterServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        DataReaderService dataReaderService = new CsvDataReaderServiceImpl();
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl(strategy);
        DataWriterService dataWriterService = new CsvDataWriterServiceImpl();

        final String fromFileName = "src/main/resources/shop.csv";
        final String toFileName = "src/main/resources/report.csv";

        List<String> data = dataReaderService.readFromFile(fromFileName);
        String report = reportGeneratorService.generateReport(data);
        dataWriterService.writeToFile(toFileName, report);
    }
}



