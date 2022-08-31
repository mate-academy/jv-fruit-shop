package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalaceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.FileCreationService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FileCreationServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final String FILE_WITH_DAY_ACTIVITIES = "src/main/resources/file.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalaceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategy(map);

        ReaderService readerService = new ReaderFileServiceImpl();
        List<String> lines = readerService.readData(FILE_WITH_DAY_ACTIVITIES);
        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> fruitTransactions = parseService.parseLines(lines);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler handler = strategy
                    .getByOperation(fruitTransaction.getOperation());
            handler.apply(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();
        FileCreationService createFileServise = new FileCreationServiceImpl();
        createFileServise.createFile(REPORT_FILE);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, REPORT_FILE);

    }

}
