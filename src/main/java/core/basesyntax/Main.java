package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;

import java.nio.file.Path;
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
        csvFileWriterService.writerToFile(LOCATION_OF_THE_REPORT_FILE, report);
    }
}
