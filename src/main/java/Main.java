import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportProcessor;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportProcessorImpl;
import java.util.List;

public class Main {
    public static final String DATA_FILE_NAME = "src/main/resources/test.csv";
    public static final String REPORT_FILE_NAME = "src/main/resources/report.csv";
    public static final String CSV_PARSER_DELIMITER = ",";
    public static final String HEADER = "fruit,quantity";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> linesFromCsv = reader.read(DATA_FILE_NAME);
        ParserService<Transaction> parserService =
                new ParserServiceImpl().setDelimiter(CSV_PARSER_DELIMITER);
        List<Transaction> transactions = parserService.parse(linesFromCsv);
        Storage storage = Storage.of(transactions);
        ReportProcessor<String> reportProcessor =
                ReportProcessorImpl.of(storage.getTransactionsData(), HEADER);
        String report = reportProcessor.getReport();
        FileWriter<String> writer = new FileWriterImpl();
        writer.write(report, REPORT_FILE_NAME);
    }
}
