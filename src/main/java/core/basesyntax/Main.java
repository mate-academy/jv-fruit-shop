package core.basesyntax;

import core.basesyntax.data.processing.TransactionParser;
import core.basesyntax.data.processing.TransactionParserImpl;
import core.basesyntax.file.processing.CsvFileReader;
import core.basesyntax.file.processing.CsvFileReaderImpl;
import core.basesyntax.file.processing.CsvFileWriter;
import core.basesyntax.file.processing.CsvFileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.implementations.ReportCreatorImpl;
import core.basesyntax.service.implementations.TransactionProcessorImpl;
import java.util.List;

public class Main {
    public static final String FILE_PATH = "src/main/resources/";
    public static final String FILE_NAME_FROM = "database.csv";
    public static final String FILE_NAME_TO = "report.csv";

    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReaderImpl(FILE_PATH + FILE_NAME_FROM);
        List<String> lines = csvFileReader.read();

        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> transactions = parser.parseTransactions(lines);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.process(transactions);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.create();

        CsvFileWriter writing = new CsvFileWriterImpl(FILE_PATH + FILE_NAME_TO);
        writing.writing(report);
    }
}
