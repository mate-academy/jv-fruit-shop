package core.basesyntax;

import core.shop.handler.BalanceHandler;
import core.shop.handler.OperationHandler;
import core.shop.handler.PurchaseHandler;
import core.shop.handler.ReturnHandler;
import core.shop.handler.SupplyHandler;
import core.shop.handler.strategy.OperationStrategyImpl;
import core.shop.model.FruitTransaction;
import core.shop.model.OperationType;
import core.shop.service.CalculateQuantityService;
import core.shop.service.FileReadService;
import core.shop.service.FileWriteService;
import core.shop.service.ParseFruitTransactionService;
import core.shop.service.ReportService;
import core.shop.service.impl.CalculateQuantityServiceImpl;
import core.shop.service.impl.FileReadServiceImpl;
import core.shop.service.impl.FileWriteServiceImpl;
import core.shop.service.impl.ParseFruitTransactionServiceImpl;
import core.shop.service.impl.ReportServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private static final String DATABASE_FILE = "src/main/resources/database.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(OperationType.BALANCE, new BalanceHandler());
        operationStrategyMap.put(OperationType.PURCHASE, new PurchaseHandler());
        operationStrategyMap.put(OperationType.SUPPLY, new SupplyHandler());
        operationStrategyMap.put(OperationType.RETURN, new ReturnHandler());

        FileReadService reader = new FileReadServiceImpl();
        List<String> strings = reader.read(DATABASE_FILE);

        ParseFruitTransactionService parser = new ParseFruitTransactionServiceImpl();
        List<FruitTransaction> transactions = parser.getFruitOperations(strings);
        CalculateQuantityService calculator =
                new CalculateQuantityServiceImpl(new OperationStrategyImpl(operationStrategyMap));

        calculator.calculate(transactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();

        FileWriteService writer = new FileWriteServiceImpl();
        writer.write(REPORT_FILE, report);
    }

}
