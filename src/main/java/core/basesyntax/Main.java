package core.basesyntax;

import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.impl.CsvFileReader;
import core.basesyntax.impl.CsvFileWriter;
import core.basesyntax.impl.CsvReportService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME_READ = "src/main/java/input.csv";
    private static final String FILE_NAME_WRITE = "src/main/java/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new CsvFileReader();
        List<String> linesInFiles = fileReaderService.readFromFile(FILE_NAME_READ);

        FruitParser fruitParser = new FruitParser();
        List<FruitTransaction> fruitTransactions = fruitParser.parseLinesInFile(linesInFiles);

        Map<Operation, OperationHandler> operationHandlerMap = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.handleOperation(fruitTransaction);
        }

        ReportService reportService = new CsvReportService();
        String report = reportService.getReport();

        FileWriterService fileWriter = new CsvFileWriter();
        fileWriter.writeToFile(report, FILE_NAME_WRITE);
    }
}
