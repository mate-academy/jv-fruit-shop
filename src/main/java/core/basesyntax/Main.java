package core.basesyntax;

import core.basesyntax.operations.BalanceOperationAction;
import core.basesyntax.operations.OperationAction;
import core.basesyntax.operations.PurchasingOperationAction;
import core.basesyntax.operations.ReturningOperationAction;
import core.basesyntax.operations.SupplingOperationAction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.TransactionParserServiceImpl;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        final ReportService reportService = new ReportServiceImpl();
        FileReaderService fileContentReader = new FileReaderServiceImpl();
        String filePath = "src" + File.separator + "main" + File.separator + "java"
                + File.separator + "core" + File.separator
                + "basesyntax" + File.separator + "files"
                + File.separator + "inputData.txt";
        List<String> list = fileContentReader.readFromFile(filePath);

        final List<FruitTransaction> fruitTransactionList =
                new TransactionParserServiceImpl().parse(list);
        Map<FruitTransaction.Operation, OperationAction> operationsMap = new HashMap<>();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationAction());
        operationsMap.put(FruitTransaction.Operation.PURCHASE, new PurchasingOperationAction());
        operationsMap.put(FruitTransaction.Operation.RETURN, new ReturningOperationAction());
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new SupplingOperationAction());

        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            new OperationStrategyImpl(operationsMap, fruitTransaction)
                    .getOperation(fruitTransaction.getOperation());
        }
        reportService.generateReport();
    }
}
