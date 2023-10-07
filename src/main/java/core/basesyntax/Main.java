package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.BalanceOperationStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationStrategy;
import core.basesyntax.strategy.ReturnOperationStrategy;
import core.basesyntax.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        Storage storage = Storage.getInstance();
        Map<String, OperationStrategy> operationStrategies = initializeStrategies();
        FruitService fruitService = new FruitServiceImpl(operationStrategies);
        List<String> inputLines = readerService.readFromFile(INPUT_FILE);
        List<FruitTransaction> transactions = parseService.parseTransactions(inputLines);
        fruitService.processTransactions(transactions);
        List<String> report = reportService.generateReport(storage);
        writerService.writeToFile(OUTPUT_FILE, report);
    }

    private static Map<String, OperationStrategy> initializeStrategies() {
        Map<String, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put("b", new BalanceOperationStrategy());
        operationStrategies.put("s", new SupplyOperationStrategy());
        operationStrategies.put("p", new PurchaseOperationStrategy());
        operationStrategies.put("r", new ReturnOperationStrategy());
        return operationStrategies;
    }
}
