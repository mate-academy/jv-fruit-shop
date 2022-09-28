package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileWriterServiceImpl;
import core.basesyntax.service.InputDataService;
import core.basesyntax.service.InputDataServiceImpl;
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
        FruitDao fruitDao = new FruitDaoImpl();
        BalanceHandler balanceService = new BalanceHandler(fruitDao);
        PurchaseService purchaseService = new PurchaseService(fruitDao);
        SupplyService supplyService = new SupplyService(fruitDao);
        ReturnService returnService = new ReturnService(fruitDao);

        Map<Operation, OperationHandler> operationOperationsMap = new HashMap<>();
        operationOperationsMap.put(Operation.BALANCE, balanceService);
        operationOperationsMap.put(Operation.PURCHASE, purchaseService);
        operationOperationsMap.put(Operation.SUPPLY, supplyService);
        operationOperationsMap.put(Operation.RETURN, returnService);
        File inputFile = new File("inputData.csv");

        FileWriterService fileWriterService = new FileWriterServiceImpl();

        fileWriterService.writeToFile(inputFile.toString(), "b,banana,20" + System.lineSeparator()
                + "b,apple,100" + System.lineSeparator()
                + "s,banana,100" + System.lineSeparator()
                + "p,banana,13" + System.lineSeparator()
                + "r,apple,10");

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        InputDataService inputDataService = new InputDataServiceImpl();
        List <FruitTransaction> fruitTransactionList = inputDataService.stringToFruitTransactionConverter(fileReaderService.read(inputFile.toString()));

        fruitTransactionList.forEach(fruitTransaction -> new ShopServiceImpl(operationOperationsMap)
                .transaction(fruitTransaction)
                .handle(fruitTransaction));

        File outputFile = new File("outputData.csv");
        FileWriterService writerService = new FileWriterServiceImpl();
        OutputDataService outputDataService = new OutputDataServiceImpl();
        writerService.writeToFile(outputFile.toString(), outputDataService.toStringConverter());
    }
}
