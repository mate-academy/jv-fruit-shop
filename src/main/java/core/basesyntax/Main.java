package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.CalculateServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.impl.OperationHandlerBalanceImpl;
import core.basesyntax.strategy.impl.OperationHandlerPurchaseImpl;
import core.basesyntax.strategy.impl.OperationHandlerReturnImpl;
import core.basesyntax.strategy.impl.OperationHandlerSupplyImpl;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OPERATIONS_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Storage storage = new Storage();
        Map<FruitTransaction.Operation,
                        OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new OperationHandlerBalanceImpl(storage));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationHandlerPurchaseImpl(storage));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new OperationHandlerReturnImpl(storage));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new OperationHandlerSupplyImpl(storage));

        ReadService readService = new ReadServiceImpl();
        List<String> fruitsOperations = readService.read(new File(OPERATIONS_FILE));
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> fruitsTransactions
                = parser.parse(fruitsOperations);

        CalculateService calculateServiceReport
                = new CalculateServiceImpl(new OperationHandlerStrategy(handlerMap));
        calculateServiceReport.put(fruitsTransactions);
        ReportService reportService = new ReportServiceImpl(storage);
        String report = reportService.getReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, REPORT_FILE);
    }
}
