package core.basesyntax;

import core.basesyntax.handler.BalanceHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseHandler;
import core.basesyntax.handler.ReturnHandler;
import core.basesyntax.handler.SupplyHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.StrategyOptions;
import core.basesyntax.strategy.StrategyOptionsImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    private static final String FILE_INPUT = "src/main/resources/testInput.csv";
    private static final String FILE_OUTPUT = "src/main/resources/testOutput.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> operationStrategy
            = new HashMap<>();
    private static ReaderService reader = new ReaderServiceImpl();
    private static StrategyOptions strategyOptions = new StrategyOptionsImpl(operationStrategy);
    private static TransactionParser transactionParser = new TransactionParserImpl(strategyOptions);
    private static ReportService reportCreated = new ReportServiceImpl();
    private static WriteService writer = new WriteServiceImpl();

    public static void main(String[] args) {
        operationStrategy.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationStrategy.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationStrategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationStrategy.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        List<String> strings = reader.readFile(FILE_INPUT);
        transactionParser.saveToDb(strings);
        String report = reportCreated.createReport();
        writer.writeReport(FILE_OUTPUT, report);
    }
}
