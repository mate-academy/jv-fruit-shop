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
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/fruits_info.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        initialization(map);
        OperationStrategy operationStrategy = new OperationStrategyImpl(map);

        ReadService readService = new ReadServiceImpl();
        List<String> readFromFile = readService.readFromFile(INPUT_FILE_PATH);

        ParseFruits parseFruits = new ParseFruitsImpl();
        List<FruitTransaction> parse = parseFruits.parse(readFromFile);

        for (FruitTransaction fruitTransaction : parse) {
            OperationHandler strategy = operationStrategy
                    .getOperationHandler(fruitTransaction.getOperation());
            strategy.handle(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(report, OUTPUT_FILE_PATH);
    }

    public static void initialization(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

    }
}
