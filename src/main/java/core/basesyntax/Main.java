package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.CreateFileService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.CreateFileServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
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
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategy(map);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFromFile(INPUT_FILE_PATH);

        ParserService parseService = new ParserServiceImpl();
        List<Transaction> transactions = parseService.parse(lines);

        for (Transaction transaction : transactions) {
            OperationHandler handler = strategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        CreateFileService createFileService = new CreateFileServiceImpl();
        createFileService.createFile(OUTPUT_FILE_PATH);

        FileWriterService writeToFileService = new FileWriterServiceImpl();
        writeToFileService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
