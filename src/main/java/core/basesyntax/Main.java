package core.basesyntax;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlersMap = new HashMap<>();
        handlersMap.put("b", new BalanceOperationHandler());
        handlersMap.put("s", new SupplyOperationHandler());
        handlersMap.put("r", new ReturnOperationHandler());
        handlersMap.put("p", new PurchaseOperationHandler());

        Strategy operationStrategy = new StrategyImpl(handlersMap);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> data = fileReaderService.read(INPUT_FILE_PATH);

        ParserService parseService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parseService.parse(data);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy.get(
                    fruitTransaction.getOperation());
            operationHandler.process(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.makeReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
