package core.basesyntax;

import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operational;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationsExecutorService;
import core.basesyntax.service.OperationsParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.OperationsExecutorServiceImpl;
import core.basesyntax.service.impl.OperationsParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Map<String, Operational> operationMap = new HashMap<>();
        operationMap.put(Operation.SUPPLY.getOperation(), new SupplyOperation());
        operationMap.put(Operation.RETURN.getOperation(), new ReturnOperation());
        operationMap.put(Operation.BALANCE.getOperation(), new BalanceOperation());
        operationMap.put(Operation.PURCHASE.getOperation(), new PurchaseOperation());
        OperationStrategy fruitOperationStrategy = new OperationStrategyImpl(operationMap);
        FileReaderService fileReader = new FileReaderServiceImpl();
        OperationsParserService importOperations = new OperationsParserServiceImpl();
        FileWriterService writeFile = new FileWriterServiceImpl();
        OperationsExecutorService operationsExecutorService
                = new OperationsExecutorServiceImpl(fruitOperationStrategy);
        ReportService exportReport = new ReportServiceImpl();

        List<String> importInfo = fileReader.readFromFile("src/main/resources/importFile.csv");
        List<String[]> listOfOperations = importOperations.parseOperations(importInfo);
        operationsExecutorService.executeOperations(listOfOperations);
        String report = exportReport.createReport();

        writeFile.writeToFile(report, "src/main/resources/exportFile.csv");
    }
}
