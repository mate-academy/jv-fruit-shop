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
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/file.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();

        String dataFromFile = csvFileReaderService.readFromFile(Path.of(INPUT_FILE_PATH));
        List<FruitTransaction> transactions = fruitTransactionParser.toTransactions(dataFromFile);
        transactionProcessor.process(transactions);
        String report = reportGenerator.createReport();
        csvFileWriterService.writerToFile(Path.of(OUTPUT_FILE_PATH), report);
    }
}
