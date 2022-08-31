package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.CsvWriter;
import core.basesyntax.service.FruitStorageService;
import core.basesyntax.service.ReportHandler;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.CsvWriterImpl;
import core.basesyntax.service.impl.FruitStorageServiceImpl;
import core.basesyntax.service.impl.FruitStoreReportHandler;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.strategy.impl.FruitBalanceOperationHandler;
import core.basesyntax.strategy.impl.FruitPurchaseOperationHandler;
import core.basesyntax.strategy.impl.FruitReturnOperationHandler;
import core.basesyntax.strategy.impl.FruitSupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();

        Map<String, FruitOperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put("b", new FruitBalanceOperationHandler(storageDao));
        operationHandlers.put("s", new FruitSupplyOperationHandler(storageDao));
        operationHandlers.put("p", new FruitPurchaseOperationHandler(storageDao));
        operationHandlers.put("r", new FruitReturnOperationHandler(storageDao));

        CsvReader reader = new CsvReaderImpl();
        CsvWriter writer = new CsvWriterImpl();
        ReportHandler reportHandler = new FruitStoreReportHandler();
        FruitStorageService fruitStorageService = new FruitStorageServiceImpl();

        List<String> readData = reader.readFromFile(INPUT_PATH);
        fruitStorageService.process(readData, operationHandlers);
        String report = reportHandler.makeReport(storageDao);
        writer.write(report, OUTPUT_PATH);
    }
}
