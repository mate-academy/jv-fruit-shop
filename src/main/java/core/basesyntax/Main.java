package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.ProcessDataServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.service.strategy.ActivitiesHandler;
import core.basesyntax.service.strategy.ActivitiesStrategy;
import core.basesyntax.service.strategy.ActivitiesStrategyImpl;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/remnants-of-fruit.csv");
        ReaderService readerService = new ReaderServiceImpl();
        List<String[]> readFromFile = readerService.readFromFile(file);
        ProcessDataService processDataService = new ProcessDataServiceImpl();
        List<FruitTransaction> dataServiceFromCsvRow
                = processDataService.getFromCsvRow(readFromFile);
        StorageService storage = new StorageServiceImpl();

        ActivitiesStrategy strategy = new ActivitiesStrategyImpl();
        for (int i = 0; i < dataServiceFromCsvRow.size(); i++) {
            FruitTransaction.Operation operation = dataServiceFromCsvRow.get(i).getOperation();
            ActivitiesHandler handler = strategy.get(operation);
            handler.handleActivity(storage, dataServiceFromCsvRow.get(i));
        }
        File writeReport = new File("src/main/resources/report.csv");
        WriterService writerService = new WriterServiceImpl();
        writerService.writeData(writeReport, Storage.getFruits());
    }
}
