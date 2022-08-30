package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReporterService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.ReporterServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String READ_FROM_FILE = "src/main/resources/productsInput.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/productsReport.csv";
    private static FileReaderService readerService = new CsvReaderServiceImpl();
    private static WriterService writerService = new WriterServiceImpl();
    private static ReporterService reporterService = new ReporterServiceImpl();
    private static ParserService parseService = new ParserServiceImpl();
    private static StorageDao storage = new StorageDaoImpl();

    public static void main(String[] args) {
        List<String> data = readerService.readFromFile(READ_FROM_FILE);
        OperationStrategy operationStrategy = new OperationStrategyImpl(storage);
        List<FruitTransaction> parsedData = parseService.parse(data);

        parsedData.forEach(value -> operationStrategy.get(value.getOperation())
                .executeOperation(value));

        String report = reporterService.createReport(storage.getData());
        writerService.writeToFile(WRITE_TO_FILE, report);
    }
}
