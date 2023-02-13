package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.FilerReadServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.operation.Addition;
import core.basesyntax.service.operation.Handler;
import core.basesyntax.service.operation.PurchaseImpl;
import core.basesyntax.strategy.StrategyOperation;
import core.basesyntax.strategy.StrategyOperationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";
    private static final String BALANCE_OPERATION = "b";
    private static final String PURCHASE_OPERATION = "p";
    private static final String RETURN_OPERATION = "r";
    private static final String SUPPLY_OPERATION = "s";

    public static void main(String[] args) {
        Map<String, Handler> handlers = new HashMap<>();
        handlers.put(BALANCE_OPERATION, new Addition());
        handlers.put(PURCHASE_OPERATION, new PurchaseImpl());
        handlers.put(RETURN_OPERATION, new Addition());
        handlers.put(SUPPLY_OPERATION, new Addition());
        TransactionParser parser = new TransactionParserImpl();
        FileWriteService writeService = new FileWriteServiceImpl();
        List<String> data = new FilerReadServiceImpl().readFromFile(INPUT_FILE);
        List<FruitTransaction> transactionList = parser.parseLine(data);
        StrategyOperation operationStrategy = new StrategyOperationImpl(handlers);
        for (FruitTransaction result : transactionList) {
            Handler handler = operationStrategy.get(result.getOperation());
            handler.apply(result);
        }
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();
        writeService.writeToFile(report, OUTPUT_FILE);
    }
}
