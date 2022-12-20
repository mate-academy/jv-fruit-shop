package core.basesyntax;

import core.basesyntax.operations.BalanceFruitTransaction;
import core.basesyntax.operations.FruitTransaction;
import core.basesyntax.operations.PurchasingFruitTransaction;
import core.basesyntax.operations.ReturningFruitTransaction;
import core.basesyntax.operations.SupplingFruitTransaction;
import core.basesyntax.service.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static String filePath = "src" + File.separator + "main" + File.separator + "sources"
            + File.separator  + "inputData.txt";

    public static void main(String[] args) throws IOException {
        ReportService reportService = new ReportServiceImpl();
        FileReaderService fileContentReader = new FileReaderServiceImpl();
        List<String> list = fileContentReader.readFromFile(filePath);
        TransactionParserService transactionParserService = new TransactionParserServiceImpl();
        TransactionInvocation transactionInvocation = new TransactionInvocationImpl();
        Map<core.basesyntax.service.FruitTransaction.Operation, FruitTransaction> operationsMap = new HashMap<>();
        List<core.basesyntax.service.FruitTransaction> fruitTransactionList = transactionParserService.parse(list);
        operationsMap.put(core.basesyntax.service.FruitTransaction.Operation.BALANCE, new BalanceFruitTransaction());
        operationsMap.put(core.basesyntax.service.FruitTransaction.Operation.PURCHASE, new PurchasingFruitTransaction());
        operationsMap.put(core.basesyntax.service.FruitTransaction.Operation.RETURN, new ReturningFruitTransaction());
        operationsMap.put(core.basesyntax.service.FruitTransaction.Operation.SUPPLY, new SupplingFruitTransaction());

        transactionInvocation.invokeTransaction(fruitTransactionList, operationsMap);
        reportService.generateReport();
    }
}
