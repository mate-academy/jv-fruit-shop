package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategyHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INTPUT_FILE_NAME = "src/main/resourses/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resourses/output-report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("r", new SupplyOperationHandler());

        OperationStrategyHandler strategy = new OperationStrategyHandler(map);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFromFile(INTPUT_FILE_NAME);

        List<Transaction> transactions = new ParserServiceImpl().parse(lines);

        for (Transaction transaction : transactions) {
            OperationHandler operationHandler = strategy.getByOperation(transaction.getOperation());
            operationHandler.apply(transaction);
        }
        String report = new ReportServiceImpl().getReport();
        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
    }
}
