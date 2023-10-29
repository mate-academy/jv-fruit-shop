package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.impl.BalanceHandler;
import core.basesyntax.impl.CsvReportCreator;
import core.basesyntax.impl.CsvTransactionParser;
import core.basesyntax.impl.DefaultOperationStrategy;
import core.basesyntax.impl.FileReaderServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportCreator;
import core.basesyntax.report.WriterService;
import core.basesyntax.report.WriterServiceImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.PurchaseHandler;
import core.basesyntax.service.ReturnHandler;
import core.basesyntax.service.SupplyHandler;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "input.csv";
        final String outputFilePath = "output.csv";

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> transactionData;
        try {
            transactionData = fileReaderService.readData(inputFilePath);
        } catch (IOException e) {
            System.err.println("Error opening/reading file: " + e.getMessage());
            return;
        }

        Map<FruitTransaction.Operation, OperationHandler> customHandlers = new HashMap<>();
        customHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        customHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        customHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        customHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        DefaultOperationStrategy operationStrategy = new DefaultOperationStrategy(customHandlers);

        List<FruitTransaction> transactions;
        transactions = new CsvTransactionParser().parseTransactions(transactionData);

        Storage storage = new Storage();

        TransactionProcessor transactionProcessor;
        transactionProcessor = new TransactionProcessor(operationStrategy, storage);
        transactionProcessor.processTransactions(transactions);

        WriterService writerService = new WriterServiceImpl();

        ReportCreator reportCreator = new CsvReportCreator(writerService, outputFilePath);

        Map<String, Integer> fruitInventory = storage.getFruitInventory();
        reportCreator.createReport(fruitInventory, outputFilePath);
    }
}
