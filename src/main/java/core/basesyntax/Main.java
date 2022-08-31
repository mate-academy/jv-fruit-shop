package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
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
    private static final String INPUT_FILE = "src/main/java/resources/input.csv";
    private static final String REPORT_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put("b", new BalanceOperationHandler());
        strategyMap.put("p", new PurchaseOperationHandler());
        strategyMap.put("r", new ReturnOperationHandler());
        strategyMap.put("s", new SupplyOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategy(strategyMap);

        List<Transaction> transactions = new ParserServiceImpl()
                .parseToTransaction(new ReaderServiceImpl()
                        .readFromFile(INPUT_FILE));
        for (Transaction transaction : transactions) {
            operationStrategy
                    .getByOperation(transaction.getOperation())
                    .apply(transaction);
        }
        String report = new ReportServiceImpl().getReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(REPORT_FILE, report);
    }
}
