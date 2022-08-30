package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
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
    private static final String READ_FROM_FILE = "src/main/resources/fruits_info.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/fruits_report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategy(map);
        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFromFile(READ_FROM_FILE);
        List<Transaction> transactions = new ParserServiceImpl().parse(lines);
        for (Transaction transaction: transactions) {
            OperationHandler operationHandler =
                    operationStrategy.getByOperation(transaction.getOperation());
            operationHandler.apply(transaction);
        }
        String report = new ReportServiceImpl().createReport();
        new WriterServiceImpl().writeToFile(WRITE_TO_FILE, report);

    }
}
