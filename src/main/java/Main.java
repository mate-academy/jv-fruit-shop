import static core.basesyntax.db.Storage.fruitData;

import core.basesyntax.dataprocess.DataProcessor;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StringReportService;
import core.basesyntax.service.impl.DataReaderServiceImpl;
import core.basesyntax.service.impl.DataWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StringReportServiceImpl;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Path inputFilePath = Paths.get("src", "main", "resources", "input.csv");
    private static final Path outputFilePath = Paths.get("src", "main", "resources", "output.csv");

    public static void main(String[] args) {
        StringReportService stringReportService = new StringReportServiceImpl();
        DataReaderService dataReaderService = new DataReaderServiceImpl();
        List<FruitTransaction> transactions = dataReaderService
                .readDataFromFile(inputFilePath.toString());

        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.processTransactions(transactions, fruitData);

        ReportService reportGenerator = new ReportServiceImpl();
        Map<String, Integer> report = reportGenerator.generateReport(dataProcessor);

        DataWriterService dataWriterService = new DataWriterServiceImpl(stringReportService);
        dataWriterService.writeReportToFile(report, outputFilePath.toString());
    }
}
