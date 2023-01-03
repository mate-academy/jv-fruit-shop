package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportBuilderService;
import core.basesyntax.service.StorageUpdaterService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportBuilderServiceImpl;
import core.basesyntax.service.impl.StorageUpdaterServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";
    private static final ReaderService readerService;
    private static final DataParserService dataParserService;
    private static final StorageUpdaterService storageUpdaterService;
    private static final ReportBuilderService reportBuilderService;
    private static final WriterService writerService;

    static {
        readerService = new ReaderServiceImpl();
        dataParserService = new DataParserServiceImpl();
        storageUpdaterService = new StorageUpdaterServiceImpl();
        reportBuilderService = new ReportBuilderServiceImpl();
        writerService = new WriterServiceImpl();
    }

    public static void main(String[] args) {
        String inputData = readerService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = dataParserService.parseData(inputData);
        storageUpdaterService.updateStorage(transactions);
        String report = reportBuilderService.buildReport();
        writerService.writeDataToFile(report, OUTPUT_FILE_PATH);
    }
}
