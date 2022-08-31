package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParsedService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParsedServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/java/core/basesyntax/resources/file";
    private static final String OUTPUT_FILE_PATH = "src/main/java/core/basesyntax/resources/report";

    public static void main(String[] args) {
        Map<Transaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(Transaction.Operation.BALANCE, new BalanceOperationHandler());
        map.put(Transaction.Operation.SUPPLY, new SupplyOperationHandler());
        map.put(Transaction.Operation.RETURN, new ReturnOperationHandler());
        map.put(Transaction.Operation.PURCHASE, new PurchaseOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategy(map);
        Reader fileReader = new ReaderServiceImpl();
        List<String> data = fileReader.read(INPUT_FILE_PATH);
        ParsedService parsedService = new ParsedServiceImpl();
        List<Transaction> transactions = parsedService.parse(data);
        for (Transaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
