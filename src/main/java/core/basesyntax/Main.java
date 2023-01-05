package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvWriteService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionsService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriteServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.TransactionsServiceImpl;
import core.basesyntax.strategy.CountStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceCountStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseCountStrategyImpl;
import core.basesyntax.strategy.impl.ReturnCountStrategyImpl;
import core.basesyntax.strategy.impl.SupplyCountStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final ReaderService readerService = new CsvReaderServiceImpl();
    private static final TransactionsService processService
            = new TransactionsServiceImpl();
    private static final ReportServiceImpl reportService = new ReportServiceImpl();
    private static final CsvWriteService writeService = new CsvWriteServiceImpl();
    private static final Map<FruitTransaction.Operation, CountStrategy> countStrategyMap
            = new HashMap<>();
    private static final OperationStrategy operationStrategy
            = new OperationStrategy(countStrategyMap);
    private static final StorageServiceImpl fruitStorageUpdateService
            = new StorageServiceImpl(operationStrategy);

    static {
        countStrategyMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceCountStrategyImpl());
        countStrategyMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyCountStrategyImpl());
        countStrategyMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseCountStrategyImpl());
        countStrategyMap.put(
                FruitTransaction.Operation.RETURN, new ReturnCountStrategyImpl());
    }

    public static void main(String[] args) {
        String fileData = readerService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactions
                = processService.getTransactions(fileData);
        Map<String, Integer> fruitStorage = fruitStorageUpdateService.update(transactions);
        String report = reportService.getReport(fruitStorage);
        writeService.writeReport(REPORT_FILE_PATH, report);
    }
}
