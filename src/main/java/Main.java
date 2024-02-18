import core.basesyntax.dataprocess.DataProcessor;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.DataReaderServiceImpl;
import core.basesyntax.service.impl.DataWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        DataReaderService dataReaderService = new DataReaderServiceImpl();
        List<String> lines = dataReaderService.readDataFromFile(INPUT_FILE);

        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitTransaction> transactions = dataParserService.parseData(lines);

        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.processTransactions(transactions);

        ReportService reportGenerator = new ReportServiceImpl();
        String report = reportGenerator.generateReport();

        DataWriterService dataWriterService = new DataWriterServiceImpl();
        dataWriterService.writeToFile(report, OUTPUT_FILE);
    }
}
