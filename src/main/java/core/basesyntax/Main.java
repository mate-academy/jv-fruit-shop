package core.basesyntax;

import core.basesyntax.files.ReaderCsvFile;
import core.basesyntax.files.WriterCsvFile;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());

        ReaderCsvFile readerCsvFile = new ReaderCsvFile();
        WriterCsvFile writerCsvFile = new WriterCsvFile();
        TransactionParser parser = new TransactionParserImpl();
        StorageService activityService = new StorageServiceImpl();
        ReportService reportService = new ReportServiceImpl();

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);

        ArrayList<String> csvRowList = readerCsvFile.getLinesFromCsv(INPUT_FILE_NAME);
        ArrayList<FruitTransaction> fruitTransactionList = parser.parseCsvRow(csvRowList);
        activityService.fillActivityStorage(fruitTransactionList);
        fruitShopService.processStorage();
        writerCsvFile.writeReport(reportService.createReport(), OUTPUT_FILE_NAME);
    }

}
