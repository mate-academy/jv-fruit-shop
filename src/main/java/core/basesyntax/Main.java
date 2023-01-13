package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import java.util.List;

public class Main {
    private static final String LOCATION_OF_THE_INPUT_FILE = "src/main/resources/file.csv";
    private static final String LOCATION_OF_THE_REPORT_FILE = "src/main/resources/report.csv";
    private static CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
    private static FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
    private static TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
    private static ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();

    public static void main(String[] args) {
        String dataFromFile = csvFileReaderService.readFromFile(LOCATION_OF_THE_INPUT_FILE);
        List<FruitTransaction> transactions = fruitTransactionParser.toTransactions(dataFromFile);
        transactionProcessor.process(transactions);
        String report = reportGenerator.createReport();
        csvFileWriterService.writerToFile(report, LOCATION_OF_THE_REPORT_FILE);
    }
}
