import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportProcessor;
import core.basesyntax.service.impl.DataFileReader;
import core.basesyntax.service.impl.ParserServiceCsv;
import core.basesyntax.service.impl.ReportProcessorImpl;
import java.util.List;

public class Main {
    public static final String FILE_NAME = "src/main/resources/test.csv";
    public static final String CSV_PARSER_DELIMITER = ",";
    public static final String HEADER = "fruit,quantity";

    public static void main(String[] args) {
        DataReader reader = new DataFileReader();
        List<String> linesFromCsv = reader.read(FILE_NAME);
        ParserService<Transaction> parserService =
                new ParserServiceCsv().setDelimiter(CSV_PARSER_DELIMITER);
        List<Transaction> transactions = parserService.parse(linesFromCsv);
        Storage storage = Storage.of(transactions);
        ReportProcessor<String> reportProcessor =
                ReportProcessorImpl.of(storage.getTransactionsData(), HEADER);
        String report = reportProcessor.getReport();
        System.out.println(report);
    }
}
