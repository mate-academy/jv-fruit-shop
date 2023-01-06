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
    private static final FileReaderService fileReaderService =
            new FileReaderServiceImpl();
    private static final FruitTransactionParserService fruitTransactionParserService =
            new FruitTransactionParserServiceImpl();
    private static final FruitTransactionService fruitTransactionService =
            new FruitTransactionServiceImpl();
    private static final ReportBuilderService reportBuilderService =
            new ReportBuilderServiceImpl();
    private static final FileWriterService fileWriterService =
            new FileWriterServiceImpl();

    public static void main(String[] args) {
        String data = fileReaderService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = fruitTransactionParserService.parseData(data);
        fruitTransactionService.update(transactions);
        String report = reportBuilderService.buildReport();
        fileWriterService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
