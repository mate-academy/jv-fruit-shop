package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvWriter;
import core.basesyntax.service.Operation;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ShopServiceStrategy;
import core.basesyntax.service.TransactionConverterImpl;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {

    private static final String INPUT_DATA_FILE = "src/main/resources/TryMe.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/report_";

    public static void main(String[] args) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        Map<Operation, OperationHandler> opHandlerMap = new HashMap<>();
        opHandlerMap.put(Operation.BALANCE, new BalanceHandler(storageDao));
        opHandlerMap.put(Operation.SUPPLY, new SupplyHandler(storageDao));
        opHandlerMap.put(Operation.PURCHASE, new PurchaseHandler(storageDao));
        opHandlerMap.put(Operation.RETURN, new ReturnHandler(storageDao));

        CsvFileReader csvFileReader = new CsvFileReader();
        TransactionConverterImpl transactionConverter = new TransactionConverterImpl();
        CsvWriter csvWriter = new CsvWriter();
        ShopServiceStrategy shopStrategy = new ShopServiceStrategy(opHandlerMap);
        ReportService reportService = new ReportService();

        List<String> inputFileData = csvFileReader.readFile(INPUT_DATA_FILE);
        List<TransactionConverterImpl.FruitTransaction> transactions
                = transactionConverter.convertLines(inputFileData);
        shopStrategy.processTransactions(transactions);
        String report = reportService.createReport(storageDao);
        csvWriter.writeToFile(OUTPUT_DATA_FILE, report);
    }
}
