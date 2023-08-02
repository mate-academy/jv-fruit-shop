package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportParserImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import core.basesyntax.service.impl.TransactionValidatorImpl;
import core.basesyntax.service.impl.TransactionsParserImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.interfaces.DataProcessingService;
import core.basesyntax.service.interfaces.ReaderService;
import core.basesyntax.service.interfaces.TransactionParser;
import core.basesyntax.service.interfaces.TransactionStrategy;
import core.basesyntax.service.interfaces.WriterService;
import core.basesyntax.service.transaction.TransactionHandler;
import core.basesyntax.service.transaction.impl.BalanceTransactionHandler;
import core.basesyntax.service.transaction.impl.PurchaseTransactionHandler;
import core.basesyntax.service.transaction.impl.ReturnTransactionHandler;
import core.basesyntax.service.transaction.impl.SupplyTransactionHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Operation, TransactionHandler> handlers = Map.of(
            Operation.BALANCE, new BalanceTransactionHandler(),
            Operation.PURCHASE, new PurchaseTransactionHandler(),
            Operation.SUPPLY, new SupplyTransactionHandler(),
            Operation.RETURN, new ReturnTransactionHandler()
    );

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        String inputData = readerService.readFromFile("dataTxt/input.txt");
        TransactionParser<List<FruitTransaction>, String> transactionParser =
                new TransactionsParserImpl(new TransactionValidatorImpl());
        List<FruitTransaction> transactions = transactionParser.parse(inputData);
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(handlers);
        DataProcessingService dataProcessingService = new DataProcessingServiceImpl(
                transactionStrategy);
        dataProcessingService.processData(transactions);
        WriterService writerService = new WriterServiceImpl();
        TransactionParser<String, Map<Fruit, Integer>> reportParser = new ReportParserImpl();
        String parsedRecords = reportParser.parse(Storage.getAll());
        writerService.writeToFile("dataTxt/report.txt", parsedRecords);
    }
}
