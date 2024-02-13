import core.basesyntax.dataprocess.DataProcessor;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.DataReaderServiceImpl;
import core.basesyntax.service.impl.DataWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Path inputFilePath = Paths.get("src", "resources", "input.csv");
    private static final Path outputFilePath = Paths.get("src", "resources", "output.csv");

    public static void main(String[] args) {

        DataReaderService dataReaderService = new DataReaderServiceImpl();
        List<FruitTransaction> transactions = dataReaderService
                .readDataFromFile(inputFilePath.toString());

        DataProcessor dataProcessor = new DataProcessor(transactions, Storage.fruitData);
        dataProcessor.processTransactions();

        ReportService reportGenerator = new ReportServiceImpl();
        Map<String, Integer> report = reportGenerator.generateReport(dataProcessor);

        DataWriterService dataWriterService = new DataWriterServiceImpl();
        dataWriterService.writeReportToFile(report, outputFilePath.toString());
    }
}
