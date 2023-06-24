package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.service.OperationParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CalculatorServiceImpl;
import core.basesyntax.service.impl.OperationParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.StrategyStorageImpl;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        StrategyStorageImpl strategyStorage = new StrategyStorageImpl();
        strategyStorage.setHandlers(handlers);
        ReaderService fileReaderService = new ReaderServiceImpl();
        List<String> list = fileReaderService.read(INPUT_FILE_PATH);
        OperationParserService operationParser = new OperationParserServiceImpl();
        List<FruitTransaction> data = operationParser.parseOperation(list);
        CalculatorService storageCalculator = new CalculatorServiceImpl(strategyStorage);
        storageCalculator.calculate(data);
        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
        String report = reportGenerator.generateReport();
        WriterService fileWriterService = new WriterServiceImpl();
        fileWriterService.write(report, OUTPUT_FILE_PATH);
        System.out.println("Fruit shop report: " + System.lineSeparator() + report);
    }
}
