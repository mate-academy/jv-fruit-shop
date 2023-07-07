package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.FruitStorageService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportHandler;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitStorageServiceImpl;
import core.basesyntax.service.impl.FruitStoreReportHandler;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.WriterImpl;
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

        Reader reader = new ReaderImpl();
        Writer writer = new WriterImpl();
        ReportHandler reportHandler = new FruitStoreReportHandler(storageDao);
        FruitStorageService fruitStorageService = new FruitStorageServiceImpl(operationHandlers);

        List<String> readData = reader.readFromFile(INPUT_PATH);
        fruitStorageService.process(readData);
        String report = reportHandler.makeReport();
        writer.write(report, OUTPUT_PATH);
    }
}
