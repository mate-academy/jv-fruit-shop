package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionProcessingService;
import core.basesyntax.service.WriteToFileServise;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionProcessingServiceImpl;
import core.basesyntax.service.impl.WriteToFileServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import strategy.OperationCalculate;
import strategy.OperationCalculateStrategy;
import strategy.impl.BalanceCountStrategy;
import strategy.impl.PurchaseCountStrategy;
import strategy.impl.ReturnCountStrategy;
import strategy.impl.SupplyCountStrategy;

public class Main {
    private static final String DATA_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
    private static final WriteToFileServise writeToFileService = new WriteToFileServiceImpl();
    private static final Map<FruitTransaction.Operation, OperationCalculate> countStrategyMap =
            new HashMap<>();
    private static final OperationCalculateStrategy operationCalculateStrategy =
            new OperationCalculateStrategy(countStrategyMap);
    private static final TransactionProcessingService transactionProcessingService =
            new TransactionProcessingServiceImpl(operationCalculateStrategy);
    private static final FruitTransactionParser fruitTransactionParser =
            new FruitTransactionParserImpl();
    private static final ReportService reportService = new ReportServiceImpl();

    static {
        countStrategyMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceCountStrategy()
        );
        countStrategyMap.put(
                FruitTransaction.Operation.RETURN, new ReturnCountStrategy()
        );
        countStrategyMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyCountStrategy()
        );
        countStrategyMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseCountStrategy()
        );

    }

    public static void main(String[] args) {
        String fileData = readFromFileService.readFromFile(DATA_FILE_PATH);
        List<FruitTransaction> transactions = fruitTransactionParser.parse(fileData);
        Map<String, Integer> fruitStore = transactionProcessingService.update(transactions);
        String report = reportService.getReport(fruitStore);
        writeToFileService.writeToFile(REPORT_FILE_PATH, report);
    }
}
