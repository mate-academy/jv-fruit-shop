package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src" + File.separator + "main" + File.separator
            + "resources" + File.separator + "input.csv";
    private static final String OUTPUT_FILE_PATH = "src" + File.separator + "main" + File.separator
            + "resources" + File.separator + "output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> strings = readerService.readFromFile(INPUT_FILE_PATH);
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new ReturnOperationHandler());
        TransactionService transactionService = new TransactionServiceImpl();
        List<Transaction> transactions = transactionService.parse(strings);
        OperationStrategy strategy = new OperationStrategy(map);
        for (Transaction transaction : transactions) {
            OperationHandler handler = strategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.makeReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
