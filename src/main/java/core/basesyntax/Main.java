package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.ReadCsvFileService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.ReadCsvFileServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriteFileServiceImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";
    private static final ReadCsvFileService readFileService =
            new ReadCsvFileServiceImpl();
    private static final DataParserService fruitTransactionParser =
            new DataParserServiceImpl();
    private static final TransactionProcessor transactionProcessor =
            new TransactionProcessorImpl();
    private static final ReportGenerator reportGenerator =
            new ReportGeneratorImpl();
    private static final WriteFileService writeFileService =
            new WriteFileServiceImpl();

    public static void main(String[] args) {
        List<String> dataFromFile = readFileService.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions =
                fruitTransactionParser.parseData(dataFromFile);
        transactionProcessor.process(fruitTransactions);
        String report = reportGenerator.generateReport();
        writeFileService.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
