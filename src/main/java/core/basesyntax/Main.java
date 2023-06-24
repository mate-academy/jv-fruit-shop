package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.TransactionProcessingService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionProcessingServiceImpl;
import core.basesyntax.service.impl.TransactionsServiceImpl;
import core.basesyntax.strategy.OperationCalculator;
import core.basesyntax.strategy.impl.BalanceOperationCalculator;
import core.basesyntax.strategy.impl.OperationCalculatorStrategy;
import core.basesyntax.strategy.impl.PurchaseCalculatorStrategyImpl;
import core.basesyntax.strategy.impl.ReturnCalculatorStrategyImpl;
import core.basesyntax.strategy.impl.SupplyCalculatorStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "C:\\Users\\glebo\\IdeaProjects\\"
            + "jv-fruit-shop\\src\\main\\resources\\input.csv";
    private static final String REPORT_FILE_PATH = "C:\\Users\\glebo\\IdeaProjects\\"
            + "jv-fruit-shop\\src\\main\\resources\\report.csv";
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final FruitTransactionParser transactionsService
            = new TransactionsServiceImpl();
    private static final ReportServiceImpl reportService = new ReportServiceImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final Map<FruitTransaction.Operation, OperationCalculator> countStrategyMap
            = new HashMap<>();
    private static final OperationCalculatorStrategy operationStrategy
            = new OperationCalculatorStrategy(countStrategyMap);
    private static final TransactionProcessingService fruitStorageUpdateService
            = new TransactionProcessingServiceImpl(operationStrategy);

    static {
        countStrategyMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationCalculator());
        countStrategyMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyCalculatorStrategyImpl());
        countStrategyMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseCalculatorStrategyImpl());
        countStrategyMap.put(
                FruitTransaction.Operation.RETURN, new ReturnCalculatorStrategyImpl());
    }

    public static void main(String[] args) {
        String fileData = fileReaderService.readFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactions
                = transactionsService.parse(fileData);
        fruitStorageUpdateService.update(transactions);
        String report = reportService.getReport();
        fileWriterService.writeReport(REPORT_FILE_PATH, report);
    }
}
