package core.basesyntax;

import core.basesyntax.operation.DefaultOperationStrategy;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.handlers.BalanceHandler;
import core.basesyntax.operation.handlers.PurchaseHandler;
import core.basesyntax.operation.handlers.ReturnHandler;
import core.basesyntax.operation.handlers.SupplyHandler;
import core.basesyntax.parser.CsvTransactionParser;
import core.basesyntax.report.CsvReportCreator;
import core.basesyntax.report.ReportCreator;
import core.basesyntax.storage.Storage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "input.csv";
        final String outputFilePath = "output.csv";

        FileReaderService fileReaderService = new FileReaderImpl();
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

        ReportCreator reportCreator = new CsvReportCreator(outputFilePath);

        Map<String, Integer> fruitInventory = storage.getFruitInventory();
        try {
            reportCreator.createReport(fruitInventory, outputFilePath);
        } catch (IOException e) {
            System.err.println("Error creating report: " + e.getMessage());
        }
    }
}
