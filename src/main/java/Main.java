import core.basesyntax.dataprocess.DataProcessor;
import core.basesyntax.db.Storage;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.impl.DataReaderServiceImpl;
import core.basesyntax.service.impl.DataWriterServiceImpl;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataReaderService dataReaderService = new DataReaderServiceImpl();
        DataProcessor dataProcessor = new DataProcessor(Storage.fruitTransactions,
                Storage.fruitData);
        DataWriterService dataWriterService = new DataWriterServiceImpl();

        dataReaderService.readDataFromFile("input.csv");
        dataProcessor.processTransactions();
        Map<String, Integer> report = dataProcessor.generateReport();
        dataWriterService.writeReportToFile(report, "output.csv");
    }
}
