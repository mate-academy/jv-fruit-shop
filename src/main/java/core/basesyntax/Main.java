package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_PATH = "src/main/resources/data.csv";
    private static final String OUTPUT_DATA_PATH = "src/main/resources/report.csv";
    private static final String BALANCE = "b";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put(BALANCE, new BalanceOperationHandler());
        map.put(PURCHASE, new PurchaseOperationHandler());
        map.put(RETURN, new ReturnOperationHandler());
        map.put(SUPPLY, new SupplyOperationHandler());

        OperationStrategy strategy = new OperationStrategy(map);

        Reader reader = new ReaderImpl();
        List<String> lines = reader.readFromFile(INPUT_DATA_PATH);

        ParserService parserService = new ParserServiceImpl();
        List<Transaction> transactions = parserService.parse(lines);

        for (Transaction transaction : transactions) {
            OperationHandler operationHandler = strategy.getByOperation(transaction.getOperation());
            operationHandler.apply(transaction);
        }
        Writer writer = new WriterImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        writer.writeToFile(OUTPUT_DATA_PATH, reportCreator.createReport());
    }
}
