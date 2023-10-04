import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionsService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionsServiceImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String DATA_FILE_NAME = "src/main/resources/test.csv";
    public static final String REPORT_FILE_NAME = "src/main/resources/report.csv";
    public static final String CSV_PARSER_DELIMITER = ",";
    public static final String HEADER = "fruit,quantity";

    public static void main(String[] args) {
        FileReaderService reader = new FileReaderServiceImpl();
        List<String> linesFromCsv = reader.read(DATA_FILE_NAME);
        ParserService<Map<Fruit, List<Transaction>>, List<String>> parserService =
                new ParserServiceImpl().setDelimiter(CSV_PARSER_DELIMITER);
        Map<Fruit, List<Transaction>> transactions = parserService.parse(linesFromCsv);
        TransactionsService<Map<Fruit, List<Transaction>>, Storage> transactionsService =
                new TransactionsServiceImpl();
        Storage storage = transactionsService.process(transactions);
        ReportService<Storage, String> reportService = new ReportServiceImpl();
        String report = reportService.getReport(storage, HEADER);
        FileWriterService<String> writer = new FileWriterServiceImpl();
        writer.write(report, REPORT_FILE_NAME);
    }
}
