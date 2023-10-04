package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.BalanceOperationStrategy;
import core.basesyntax.strategy.PurchaseOperationStrategy;
import core.basesyntax.strategy.ReturnOperationStrategy;
import core.basesyntax.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/input.csv";
        String outputFile = "src/main/resources/output.csv";
        ReaderService readerService = new ReaderServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        Storage storage = Storage.getInstance();
        Map<String, OperationStrategy> operationStrategies = initializeStrategies();
        FruitService fruitService = new FruitServiceImpl(operationStrategies);
        List<String> inputLines = readerService.readFromFile(inputFile);
        for (String line : inputLines) {
            line = line.trim();
            String[] transaction = line.split("\\s*,\\s*");
            fruitService.processTransaction(transaction);
        }
        List<String> report = generateReport(storage);
        writerService.writeToFile(outputFile, report);
    }

    private static Map<String, OperationStrategy> initializeStrategies() {
        Map<String, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put("b", new BalanceOperationStrategy());
        operationStrategies.put("s", new SupplyOperationStrategy());
        operationStrategies.put("p", new PurchaseOperationStrategy());
        operationStrategies.put("r", new ReturnOperationStrategy());
        return operationStrategies;
    }

    private static List<String> generateReport(Storage storage) {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<String, FruitTransaction> entry : storage.getFruitInventory().entrySet()) {
            String fruitName = entry.getKey();
            int quantity = entry.getValue().getQuantity();
            String quantityString = (quantity >= 0) ? String.valueOf(quantity) : "-" + (-quantity);
            String reportLine = fruitName + "," + quantityString;
            report.add(reportLine);
        }
        return report;
    }
}
