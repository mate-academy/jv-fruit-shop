package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ReturnOperationHandler;
import core.basesyntax.service.impl.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE = "src/main/resources/source.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";
    private static final String REPORT_HEADER = "fruit,quantity";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationStrategyMap.put(Operation.RETURNED, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        CsvFileReader inputFile = new CsvFileReaderImpl(SOURCE_FILE);
        Storage storage = new FruitStorage(inputFile);
        CsvFileWriter outputReport = new CsvFileWriterImpl(OUTPUT_FILE);
        ReportService reportService = new ReportServiceImpl(storage, operationStrategy,
                outputReport, REPORT_HEADER);
        reportService.getReport();
    }
}
