import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportProcessor;
import core.basesyntax.service.TransactionsProcessor;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportProcessorImpl;
import core.basesyntax.service.impl.TransactionsProcessorImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String DATA_FILE_NAME = "src/main/resources/test.csv";
    public static final String REPORT_FILE_NAME = "src/main/resources/report.csv";
    public static final String CSV_PARSER_DELIMITER = ",";
    public static final String HEADER = "fruit,quantity";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> linesFromCsv = reader.read(DATA_FILE_NAME);
        ParserService<Map<Fruit, List<Transaction>>, List<String>> parserService =
                new ParserServiceImpl().setDelimiter(CSV_PARSER_DELIMITER);
        Map<Fruit, List<Transaction>> transactions = parserService.parse(linesFromCsv);
        TransactionsProcessor<Map<Fruit, List<Transaction>>, Storage> transactionsProcessor =
                new TransactionsProcessorImpl();
        Storage storage = transactionsProcessor.process(transactions);
        ReportProcessor<Storage, String> reportProcessor = new ReportProcessorImpl();
        String report = reportProcessor.getReport(storage, HEADER);
        FileWriter<String> writer = new FileWriterImpl();
        writer.write(report, REPORT_FILE_NAME);
    }
}
