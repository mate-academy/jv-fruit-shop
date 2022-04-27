package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operations;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.OperationStrategyImpl;
import core.basesyntax.service.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operations.BALANCE.getOperation(), new BalanceOperationHandler());
        operationHandlerMap.put(Operations.SUPPLY.getOperation(), new SupplyOperationHandler());
        operationHandlerMap.put(Operations.PURCHASE.getOperation(), new PurchaseOperationHandler());
        operationHandlerMap.put(Operations.RETURN.getOperation(), new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> strings = csvFileReaderService.fileReader("src/main/resources/before.csv");

        FruitTransaction fruitTransaction = new FruitTransactionImpl(operationStrategy);
        fruitTransaction.dateProcessing(strings);

        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.fileWriter("src/main/resources/after.csv");

        System.out.println(Storage.fruitStorage);
    }
}
