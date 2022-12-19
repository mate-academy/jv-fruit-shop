package core.basesyntax;

import core.basesyntax.operations.*;
import core.basesyntax.storage.StorageInformation;
import core.basesyntax.service.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        ReportService reportService = new ReportServiceImpl();
        FileReaderService fileContentReader = new FileReaderServiceImpl();
        String filePath = "src" +  File.separator + "main" + File.separator + "java" + File.separator + "core" + File.separator + "basesyntax" + File.separator + "files" + File.separator + "inputData.txt";
        List<String> list = fileContentReader.readFromFile(filePath);

        List<FruitTransaction> fruitTransactionList = new TransactionParserServiceImpl().parse(list);
        Map<FruitTransaction.Operation, OperationAction> operationsMap = new HashMap<>();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationAction());
        operationsMap.put(FruitTransaction.Operation.PURCHASE, new PurchasingOperationAction());
        operationsMap.put(FruitTransaction.Operation.RETURN, new ReturningOperationAction());
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new SupplingOperationAction());

        for(FruitTransaction fruitTransaction : fruitTransactionList) {
            new OperationStrategyImpl(operationsMap, fruitTransaction).getOperation(fruitTransaction.getOperation());
        }
        reportService.generateReport();
    }
}
