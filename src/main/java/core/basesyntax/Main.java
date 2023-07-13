package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.impl.FruitStoreReportHandler;
import core.basesyntax.impl.FruitStoreServiceImpl;
import core.basesyntax.impl.ReaderImpl;
import core.basesyntax.impl.WriterImpl;
import core.basesyntax.service.FruitStoreService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportHandler;
import core.basesyntax.service.Writer;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.stretegyImpl.FruitBalanceOperationHandler;
import core.basesyntax.stretegyImpl.FruitPurchaseOperationHandler;
import core.basesyntax.stretegyImpl.FruitReturnOperationHandler;
import core.basesyntax.stretegyImpl.FruitSupplyOperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();

        Map<String, FruitOperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new FruitBalanceOperationHandler(storageDao));
        operationHandlerMap.put("s", new FruitSupplyOperationHandler(storageDao));
        operationHandlerMap.put("p", new FruitPurchaseOperationHandler(storageDao));
        operationHandlerMap.put("r", new FruitReturnOperationHandler(storageDao));

        Reader reader = new ReaderImpl();
        Writer writer = new WriterImpl();
        FruitStoreService fruitStoreService = new FruitStoreServiceImpl(operationHandlerMap);
        ReportHandler reportHandler = new FruitStoreReportHandler(storageDao);

        List<String> readData = reader.readFromFile(INPUT_PATH);
        fruitStoreService.process(readData);
        String report = reportHandler.makeReport();
        writer.write(report, OUTPUT_PATH);
    }
}
