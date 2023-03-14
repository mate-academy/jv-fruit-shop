package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final File ACTIVITIES = new File("src/main/resources/activities.csv");
    public static final File REPORT = new File("src/main/resources/report.csv");
    public static final Map<String, OperationHandler> OPERATIONS = new HashMap<>();

    public static void main(String[] args) {
        fill();
        FileReaderService csvFileReader = new CsvFileReader();
        List<String> data = csvFileReader.readFromFile(ACTIVITIES);

        fill();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        operationStrategy.accept(data, OPERATIONS);

        FileWriterService csvFileWriter = new CsvFileWriter();
        csvFileWriter.writeToFile(REPORT);
    }

    public static void fill() {
        OPERATIONS.put("b", new BalanceOperationHandler());
        OPERATIONS.put("s", new SupplyOperationHandler());
        OPERATIONS.put("p", new PurchaseOperationHandler());
        OPERATIONS.put("r", new ReturnOperationHandler());
    }
}
