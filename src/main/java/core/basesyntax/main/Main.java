package core.basesyntax.main;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.handler.BalanceOperationHandler;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.PurchaseHandler;
import core.basesyntax.service.handler.ReturnHandler;
import core.basesyntax.service.handler.SupplyHandler;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ParserTransactionImpl;
import core.basesyntax.service.impl.ReadFromFieImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE =
            "src/main/java/core/basesyntax/resources/InputFile.csv";
    private static final String REPORT_FILE =
            "src/main/java/core/basesyntax/resources/ReportFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationStrategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationStrategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationStrategyMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        ReaderService reader = new ReadFromFieImpl();
        List<String> strings = reader.readFile(INPUT_FILE);
        ParserService parser = new ParserTransactionImpl();
        List<FruitTransaction> transactions = parser.parseRecords(strings);
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(new OperationStrategyImpl(operationStrategyMap));
        fruitShopService.processOfOperations(transactions);
        ReportGeneratorService reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport();
        WriterService writer = new WriteToFileImpl();
        writer.writeReport(report, REPORT_FILE);
    }
}
