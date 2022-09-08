package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseFruits;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.ParseFruitsImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/fruits_info.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/fruits_report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        OperationStrategyImpl.initialization(map);
        OperationStrategy operationStrategy = new OperationStrategyImpl(map);

        ReadService readService = new ReadServiceImpl();
        List<String> readFromFile = readService.readFromFile(INPUT_FILE_PATH);

        ParseFruits parseFruits = new ParseFruitsImpl();
        List<FruitTransaction> parse = parseFruits.parse(readFromFile);

        for (FruitTransaction fruitTransaction : parse) {
            OperationHandler strategy = operationStrategy
                    .getStrategy(fruitTransaction.getOperation());
            strategy.getOperationHandler(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
