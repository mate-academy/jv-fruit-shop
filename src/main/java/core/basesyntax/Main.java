package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/fruits_shop.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/fruits_report.csv";
    private static final String BALANCE = "b";
    private static final String PURCHASE = "p";
    private static final String SUPPLY = "s";
    private static final String RETURN = "r";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put(BALANCE, new BalanceOperationHandler());
        map.put(PURCHASE, new PurchaseOperationHandler());
        map.put(SUPPLY, new SupplyOperationHandler());
        map.put(RETURN, new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategy(map);

        ReaderService readerService = new ReaderServiceImpl();

        List<String> lines = readerService
                .readerFromFile(INPUT_FILE_NAME);

        List<Transaction> transactions = new ParserServiceImpl().parse(lines);

        for (Transaction transaction: transactions) {
            OperationHandler handler = strategy
                    .getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }

        String report = new ReportServiceImpl().getReport();

        new WriterServiceImpl().writeToFile(OUTPUT_FILE_NAME, report);

    }
}
