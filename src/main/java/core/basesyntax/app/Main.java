package core.basesyntax.app;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.DecrementHandler;
import core.basesyntax.strategy.IncrementHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> fileLines = fileReader.readFile("src/main/resources/input.csv");
        TransactionParser transactionParser = new TransactionParserImpl();
        StorageService storageService = new StorageServiceImpl();
        Map<Transaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Transaction.Operation.BALANCE, new IncrementHandler(storageService));
        operationHandlers.put(Transaction.Operation.PURCHASE, new DecrementHandler(storageService));
        operationHandlers.put(Transaction.Operation.RETURN, new IncrementHandler(storageService));
        operationHandlers.put(Transaction.Operation.SUPPLY, new IncrementHandler(storageService));
        List<Transaction> transactions = transactionParser.parse(fileLines);
        TransactionProcessor transactionProcessor =
                new TransactionProcessorImpl(operationHandlers);
        transactionProcessor.process(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile("src/main/resources/output.csv", report);
    }
}
