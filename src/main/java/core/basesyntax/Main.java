package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import core.basesyntax.service.impl.TransactionValidatorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.interfaces.DataProcessingService;
import core.basesyntax.service.interfaces.ReaderService;
import core.basesyntax.service.interfaces.TransactionParserService;
import core.basesyntax.service.interfaces.TransactionStrategy;
import core.basesyntax.service.interfaces.WriterService;
import core.basesyntax.service.transaction.TransactionHandler;
import core.basesyntax.service.transaction.impl.BalanceTransactionHandler;
import core.basesyntax.service.transaction.impl.PurchaseTransactionHandler;
import core.basesyntax.service.transaction.impl.ReturnTransactionHandler;
import core.basesyntax.service.transaction.impl.SupplyTransactionHandler;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final Map<Operation, TransactionHandler> handlers = Map.of(
            Operation.BALANCE, new BalanceTransactionHandler(),
            Operation.PURCHASE, new PurchaseTransactionHandler(),
            Operation.SUPPLY, new SupplyTransactionHandler(),
            Operation.RETURN, new ReturnTransactionHandler()
    );

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        String inputData = readerService.readFromFile();
        TransactionParserService parserService = new TransactionParserServiceImpl(
                new TransactionValidatorImpl());
        List<FruitTransaction> transactions = parserService.parseFruitTransaction(inputData);
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(handlers);
        DataProcessingService dataProcessingService = new DataProcessingServiceImpl(
                transactionStrategy);
        dataProcessingService.processData(transactions);
        WriterService writerService = new WriterServiceImpl();
        String parsedRecords = parserService.parseReport(Storage.getAll());
        writerService.writeToFile(parsedRecords);
    }
}
