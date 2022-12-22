package core.basesyntax;

import core.basesyntax.operations.BalanceTransactionExecutor;
import core.basesyntax.operations.PurchasingTransactionExecutor;
import core.basesyntax.operations.ReturningTransactionExecutor;
import core.basesyntax.operations.SupplingTransactionExecutor;
import core.basesyntax.operations.TransactionExecutor;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.TransactionInvocation;
import core.basesyntax.service.TransactionInvocationImpl;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.TransactionParserServiceImpl;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String transactionsFileName = "src" + File.separator + "main"
            + File.separator + "sources" + File.separator + "inputData.csv";
    private static final String reportFileName = "src" + File.separator + "main" + File.separator
            + "sources" + File.separator + "reports.csv";

    public static void main(String[] args) throws IOException {
        final TransactionParserService transactionParserService =
                new TransactionParserServiceImpl();
        final TransactionInvocation transactionInvocation = new TransactionInvocationImpl();
        final ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileService fileService = new FileServiceImpl();
        List<String> list = fileService.readFromFile(transactionsFileName);
        final List<FruitTransaction> fruitTransactionList = transactionParserService.parse(list);
        final Map<FruitTransaction.Operation, TransactionExecutor> operationsMap = new HashMap<>();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionExecutor());
        operationsMap.put(FruitTransaction.Operation.PURCHASE, new PurchasingTransactionExecutor());
        operationsMap.put(FruitTransaction.Operation.RETURN, new ReturningTransactionExecutor());
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new SupplingTransactionExecutor());
        transactionInvocation.invokeTransaction(fruitTransactionList, operationsMap);
        fileService.writeToFile(reportFileName, reportGenerator.getReport());
    }
}
