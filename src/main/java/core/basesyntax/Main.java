package core.basesyntax;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.ConditionalFirstRowRemover;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.CvsReader;
import core.basesyntax.service.impl.CvsWriter;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.RowRemover;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceHandler;
import core.basesyntax.strategy.handler.impl.PurchaseHandler;
import core.basesyntax.strategy.handler.impl.ReturnHandler;
import core.basesyntax.strategy.handler.impl.SupplyHandler;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new CvsReader();
        ProductStorage productStorage = new ProductStorage(new TreeMap<>());

        Map<Transaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Transaction.Operation.BALANCE,
                new BalanceHandler(productStorage));
        operationHandlers.put(Transaction.Operation.PURCHASE,
                new PurchaseHandler(productStorage));
        operationHandlers.put(Transaction.Operation.RETURN,
                new ReturnHandler(productStorage));
        operationHandlers.put(Transaction.Operation.SUPPLY,
                new SupplyHandler(productStorage));

        Path readPath = Path.of("src/main/resources/input.csv");
        Path writePath = Path.of("src/main/resources/report.csv");

        List<String> data = fileReader.loadDataFromFile(readPath);
        RowRemover rowRemover = new ConditionalFirstRowRemover();
        rowRemover.remove(data);

        TransactionParser transactionParser = new CsvParser();
        List<Transaction> transactions = transactionParser.parseTransactions(data);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationHandlers);
        transactionProcessor.process(transactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        FileWriter fileWriter = new CvsWriter();
        fileWriter.saveDataToFile(writePath, reportCreator.create(productStorage));
    }
}
