package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileWriterServiceImpl;
import core.basesyntax.service.OutputDataService;
import core.basesyntax.service.OutputDataServiceImpl;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operations.BalanceHandler;
import core.basesyntax.service.operations.Operation;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseService;
import core.basesyntax.service.operations.ReturnService;
import core.basesyntax.service.operations.SupplyService;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BalanceHandler balanceService = new BalanceHandler();
        PurchaseService purchaseService = new PurchaseService();
        SupplyService supplyService = new SupplyService();
        ReturnService returnService = new ReturnService();

        Map<Operation, OperationHandler> operationOperationsMap = new HashMap<>();
        operationOperationsMap.put(Operation.BALANCE, balanceService);
        operationOperationsMap.put(Operation.PURCHASE, purchaseService);
        operationOperationsMap.put(Operation.SUPPLY, supplyService);
        operationOperationsMap.put(Operation.RETURN, returnService);
        File inputFile = new File("inputData.csv");

        FileWriterService fileWriterService = new FileWriterServiceImpl();

        fileWriterService.writeToFile(inputFile, "b,banana,20" + System.lineSeparator()
                + "b,apple,100" + System.lineSeparator()
                + "s,banana,100" + System.lineSeparator()
                + "p,banana,13" + System.lineSeparator()
                + "r,apple,10");

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<FruitTransaction> fruitTransactionList = fileReaderService.read(inputFile);

        fruitTransactionList.forEach(fruitTransaction -> new ShopServiceImpl(operationOperationsMap)
                .transaction(fruitTransaction)
                .doOperation(fruitTransaction));

        File outputFile = new File("outputData.csv");
        FileWriterService writerService = new FileWriterServiceImpl();
        OutputDataService outputDataService = new OutputDataServiceImpl();
        writerService.writeToFile(outputFile, outputDataService.toStringConverter());

    }
}

