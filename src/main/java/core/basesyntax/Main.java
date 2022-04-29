package core.basesyntax;

import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operations;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
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
        List<String> strings = csvFileReaderService.readFromFile("src/main/resources/before.csv");

        FruitTransactionService fruitTransaction
                = new FruitTransactionServiceImpl(operationStrategy);
        fruitTransaction.process(strings);

        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.writeToFile("src/main/resources/after.csv",
                new ReportServiceImpl(new FruitShopDaoImpl()));

        System.out.println(Storage.fruitStorage);
    }
}
