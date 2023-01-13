package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.DataTransactionService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.DataTransactionServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH
            = "src/main/resources/transaction.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final DataParserService dataParserService = new DataParserServiceImpl();
    private static final DataTransactionService stringParser = new DataTransactionServiceImpl();
    private static final ReportCreatorService reportCreator = new ReportCreatorServiceImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();

    public static void main(String[] args) {
        List<String> fruitConsider = fileReaderService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = dataParserService.toTransactions(fruitConsider);
        stringParser.parseData(fruitTransactions);
        String report = reportCreator.createReport();
        fileWriterService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
