package service.basesyntax.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.basesyntax.db.Storage;
import service.basesyntax.model.FruitTransaction;
import service.basesyntax.service.ReaderService;
import service.basesyntax.service.ShopService;
import service.basesyntax.service.TransactionParserService;
import service.basesyntax.service.TransactionReaderService;
import service.basesyntax.service.WriterService;
import service.basesyntax.service.impl.OperationStrategyImpl;
import service.basesyntax.service.impl.ReaderServiceImpl;
import service.basesyntax.service.impl.ShopServiceImpl;
import service.basesyntax.service.impl.TransactionParserImpl;
import service.basesyntax.service.impl.WriterServiceImpl;
import service.basesyntax.service.strategy.BalanceHandler;
import service.basesyntax.service.strategy.OperationHandler;
import service.basesyntax.service.strategy.PurchaseHandler;
import service.basesyntax.service.strategy.ReturnHandler;
import service.basesyntax.service.strategy.SupplyHandler;

public class Main {
    private static final String PATH_TO_READ = "src/main/resources/reportToRead.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/reportToWrite.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        TransactionReaderService transactionReaderService =
                new TransactionReaderService(readerService);
        List<String> lines = transactionReaderService.readTransactions(PATH_TO_READ);

        TransactionParserService transactionParserService =
                new TransactionParserService(new TransactionParserImpl());

        Map<FruitTransaction.Operation, OperationHandler> storageStrategy = new HashMap<>();
        storageStrategy.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        storageStrategy.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        storageStrategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        storageStrategy.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(storageStrategy);
        List<FruitTransaction> transactions = transactionParserService.parseTransactions(lines);
        Storage storage = new Storage();
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        WriterService writerService = new WriterServiceImpl();
        writerService.write(storage.getStorage(), PATH_TO_WRITE);
    }
}
