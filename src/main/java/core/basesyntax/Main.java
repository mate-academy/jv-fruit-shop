package core.basesyntax;

import core.basesyntax.dao.FileService;
import core.basesyntax.dao.FileServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionConverter;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionConverterImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.BalanceOperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationStrategy;
import core.basesyntax.strategy.ReturnOperationStrategy;
import core.basesyntax.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputReport";
    private static final String RESULT_FILE_PATH = "src/main/resources/resultReport";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        String data = fileService.readFile(INPUT_FILE_PATH);

        TransactionConverter fruitInfoConverter = new TransactionConverterImpl();
        List<FruitTransaction> transactions = fruitInfoConverter.parse(data);

        Map<String, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceOperationStrategy());
        operationStrategyMap.put("p", new PurchaseOperationStrategy());
        operationStrategyMap.put("s", new SupplyOperationStrategy());
        operationStrategyMap.put("r", new ReturnOperationStrategy());

        TransactionService transactionService =
                new TransactionServiceImpl(operationStrategyMap);
        Map<String, Integer> groupedTransactions =
                transactionService.handleTransactions(transactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(groupedTransactions);

        fileService.writeToFile(report, RESULT_FILE_PATH);
    }
}
