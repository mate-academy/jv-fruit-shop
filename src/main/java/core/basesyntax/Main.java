package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String READ_FROM_FILE = "src/main/resources/productsInput.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/productsReport.csv";
    private static ReaderService readerService = new ReaderServiceImpl();
    private static WriterService writerService = new WriteServiceImpl();
    private static ReportService reporterService = new ReportServiceImpl();
    private static ParseService parseService = new ParseServiceImpl();
    private static StorageDao storage = new StorageDaoImpl();

    public static void main(String[] args) {
        List<String> data = readerService.readFromFile(READ_FROM_FILE);
        OperationStrategy operationStrategy = new OperationStrategyImpl(storage);
        List<FruitTransaction> parsedData = parseService.parse(data);

        parsedData.forEach(value -> operationStrategy.get(value.getOperation())
                .executeOperation(value));
        System.out.println(storage.getData());

        String report = reporterService.createReport(storage.getData());
        writerService.writeToFile(WRITE_TO_FILE, report);
    }
}
