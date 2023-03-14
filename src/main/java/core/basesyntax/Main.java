package core.basesyntax;

import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.DataParseServiceImpl;
import core.basesyntax.strategy.OperationHandler;
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
    private static final File ACTIVITIES = new File("src/main/resources/activities.csv");
    private static final File REPORT = new File("src/main/resources/report.csv");
    private static final Map<String, OperationHandler> OPERATIONS = new HashMap<>();

    public static void main(String[] args) {
        List<String> data = new CsvFileReader().readFromFile(ACTIVITIES);
        List<String[]> parsedData = new DataParseServiceImpl().parseData(data);

        fill();
        new OperationStrategyImpl().accept(parsedData, OPERATIONS);

        new CsvFileWriter().writeToFile(REPORT);
    }

    public static void fill() {
        OPERATIONS.put("b", new BalanceOperationHandler());
        OPERATIONS.put("s", new SupplyOperationHandler());
        OPERATIONS.put("p", new PurchaseOperationHandler());
        OPERATIONS.put("r", new ReturnOperationHandler());
    }
}
