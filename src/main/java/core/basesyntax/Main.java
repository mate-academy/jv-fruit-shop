package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.FilerReadServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.operation.AdditionHandlerImpl;
import core.basesyntax.service.operation.Handler;
import core.basesyntax.service.operation.PurchaseHandlerImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, Handler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new AdditionHandlerImpl());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandlerImpl());
        handlers.put(FruitTransaction.Operation.RETURN, new AdditionHandlerImpl());
        handlers.put(FruitTransaction.Operation.SUPPLY, new AdditionHandlerImpl());
        TransactionParser parser = new TransactionParserImpl();
        FileWriteService writeService = new FileWriteServiceImpl();
        List<String> data = new FilerReadServiceImpl().readFromFile(INPUT_FILE);
        List<FruitTransaction> transactionList = parser.parseList(data);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);
        for (FruitTransaction result : transactionList) {
            Handler handler = operationStrategy.get(result.getOperation());
            handler.handle(result);
        }
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();
        writeService.writeToFile(report, OUTPUT_FILE);
    }
}
