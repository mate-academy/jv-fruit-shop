package core.basesyntax;

import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseHandler;
import core.basesyntax.handler.ReturnHandler;
import core.basesyntax.handler.SupplyHandler;
import core.basesyntax.implementation.FruitShopServiceImpl;
import core.basesyntax.implementation.ParserServiceImpl;
import core.basesyntax.implementation.ReaderServiceImpl;
import core.basesyntax.implementation.ReportGeneratorServiceImpl;
import core.basesyntax.implementation.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE =
            "src/main/java/resources/database";
    private static final String REPORT_FILE =
            "src/main/java/resources/ReportFile";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationStrategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationStrategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationStrategyMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        ReaderService reader = new ReaderServiceImpl();
        List<String> strings = reader.readFile(INPUT_FILE);
        ParserService parser = new ParserServiceImpl();
        List<FruitTransaction> transactions = parser.parseRecords(strings);
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(new OperationStrategyImpl(operationStrategyMap));
        fruitShopService.processOfOperations(transactions);
        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
        String report = reportGenerator.generateReport();
        WriterService writer = new WriterServiceImpl();
        writer.writeReport(report, REPORT_FILE);
    }
}
