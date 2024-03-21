package core.basesyntax;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.Operation;
import core.basesyntax.dto.ProductTransaction;
import core.basesyntax.service.CsvDataProcessor;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.ReportCreatorImpl;
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
        FileReader fileReader = new CsvReader();
        ProductStorage productStorage = new ProductStorage(new TreeMap<>());

        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE,
                new BalanceHandler(productStorage));
        operationHandlers.put(Operation.PURCHASE,
                new PurchaseHandler(productStorage));
        operationHandlers.put(Operation.RETURN,
                new ReturnHandler(productStorage));
        operationHandlers.put(Operation.SUPPLY,
                new SupplyHandler(productStorage));

        Path readPath = Path.of("src/main/resources/input.csv");
        Path writePath = Path.of("src/main/resources/report.csv");

        List<String> data = fileReader.readFromFile(readPath);

        TransactionParser transactionParser = new CsvParser(new CsvDataProcessor());
        List<ProductTransaction> productTransactions = transactionParser.parseTransactions(data);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationHandlers);
        transactionProcessor.process(productTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        FileWriter fileWriter = new CsvWriter();
        fileWriter.writeToFile(writePath, reportCreator.create(productStorage));
    }
}
