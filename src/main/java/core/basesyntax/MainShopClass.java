package core.basesyntax;

import core.basesyntax.fileService.FileService;
import core.basesyntax.fileService.FileServiceImpl;
import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.TransactionParserImp;
import core.basesyntax.impl.TransactionServiceImpl;
import core.basesyntax.operations.Operation;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class MainShopClass {
    public static final String INPUT_PATH_FILE = "src/main/resources/inputFile";
    public static final String RESULT_PATH_FILE = "src/main/resources/resultFile";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        String data = fileService.readFile(INPUT_PATH_FILE);

        TransactionParser transactionParser = new TransactionParserImp();
        final List<FruitTransaction> fruitTransactions = transactionParser.parse(data);

        Map<Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceOperationStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SuplyOperationStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseOperationStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnOperationStrategy());

        TransactionService transactionService = new TransactionServiceImpl(operationStrategyMap);
        transactionService.handleTransaction(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        fileService.writeToFile(report, RESULT_PATH_FILE);
    }
}
