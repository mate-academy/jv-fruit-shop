package core.basesyntax;

import core.basesyntax.dao.FruitParser;
import core.basesyntax.dao.ShopParser;
import core.basesyntax.dao.impl.FruitParserImpl;
import core.basesyntax.dao.impl.ShopParserImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitShopService;
import core.basesyntax.services.ReaderService;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.WriterService;
import core.basesyntax.services.impl.FruitShopServiceImpl;
import core.basesyntax.services.impl.ReaderServiceImpl;
import core.basesyntax.services.impl.ReportServiceImpl;
import core.basesyntax.services.impl.WriterServiceImpl;
import core.basesyntax.strategy.GeneralOperation;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/dataInput.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/dataReport.csv";

    public static void main(String[] args) {
        // FileReader fileReader = new FileReaderImpl();
        // List<String> dataFromFile = fileReader.read(INPUT_FILE)

        // "b,apple,10" -> FruitTransaction

        // TransactionParser parser = new FruitTransactionCsvParser();
        // List<FruitTransaction> transactions = parser.parse(dataFromFile);

        // FruitStorageDao storageDao = new StorageDaoImpl();

        // Map<FruitTransaction.Operation, OperationHandler> handlersMap = new HashMap<>();
        // handlersMap.put(FruitTransaction.Operation.RETURN,
        // new ReturnOperationHandler(storageDao);
        // ..

        // OperationHandlerStrategy strategy = new OperationHandlerStrategyImpl(handlersMap);

        // strategy {    OperationHandler get(Operation) }
        // handler {     void handle(transaction) }

        // for (transaction) {
        //    strategy.get(transaction.getOperation()).handle(transaction)
        // }

        // ReportCreator reportCreator = new CsvReportCreatorImpl();

        // Map<String, Integer> dataFromDb = ..
        // String report = reportCreator.createReport(Storage.storage);

        // FileWriter fileWriter = new FileWriterImpl();
        // fileWriter.write(report, OUTPUT_NAME)
        ReaderService readerService = new ReaderServiceImpl();
        String dateFromFile = readerService.readFile(INPUT_FILE_PATH);

        ShopParser shopParser = new ShopParserImpl();
        String[] parsedDate = shopParser.parse(dateFromFile);

        Map<FruitTransaction.Operation, GeneralOperation> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        FruitParser parseFruit = new FruitParserImpl();
        List<FruitTransaction> fruitTransactions = parseFruit.parse(parsedDate);

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationHandlersMap);
        fruitShopService.transfer(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        WriterService fileWriterService = new WriterServiceImpl();
        fileWriterService.writeToFile(report, REPORT_FILE_PATH);
        System.out.println(readerService.readFile(REPORT_FILE_PATH));
    }

}
