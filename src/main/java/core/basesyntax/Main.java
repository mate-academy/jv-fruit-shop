package core.basesyntax;

import core.basesyntax.dao.FileService;
import core.basesyntax.dao.FileServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
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

        TransactionParser transactionParser = new TransactionParserImpl();
        final List<FruitTransaction> transactions = transactionParser.parse(data);

        Map<Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceOperationStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseOperationStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyOperationStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnOperationStrategy());

        TransactionService transactionService = new TransactionServiceImpl(operationStrategyMap);
        transactionService.handleTransactions(transactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        fileService.writeToFile(report, RESULT_FILE_PATH);
    }
}
