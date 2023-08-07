package core.basesyntax;

import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
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
    public static final Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
    private static final String fromFileName = "src/main/resources/shop.csv";
    private static final String toFileName = "src/main/resources/report.csv";

    public static void main(String[] args) {
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());

        FileReader fileReader = new FileReaderImpl();
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        FileWriter fileWriter = new FileWriterImpl();

        List<String> data = fileReader.readFromFile(fromFileName);
        String report = reportGeneratorService.generateReport(data);
        fileWriter.writeToFile(toFileName, report);
    }
}



