package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionParserService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportBuilderService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReportBuilderServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";
    private static final FileReaderService readerService =
            new FileReaderServiceImpl();
    private static final FruitTransactionParserService dataParserService =
            new FruitTransactionParserServiceImpl();
    private static final FruitTransactionService storageUpdaterService =
            new FruitTransactionServiceImpl();
    private static final ReportBuilderService reportBuilderService =
            new ReportBuilderServiceImpl();
    private static final FileWriterService writerService =
            new FileWriterServiceImpl();

    public static void main(String[] args) {
        String inputData = readerService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = dataParserService.parseData(inputData);
        storageUpdaterService.update(transactions);
        String report = reportBuilderService.buildReport();
        writerService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
