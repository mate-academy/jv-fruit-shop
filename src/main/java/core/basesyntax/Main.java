package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.CsvWriter;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ReportHandler;
import core.basesyntax.serviceimpl.CsvReaderImpl;
import core.basesyntax.serviceimpl.CsvWriterImpl;
import core.basesyntax.serviceimpl.FruitStoreReportHandler;
import core.basesyntax.serviceimpl.FruitTransactionImpl;
import core.basesyntax.strategy.FruitOperation;
import core.basesyntax.strategy.impl.FruitBalanceOperation;
import core.basesyntax.strategy.impl.FruitPurchaseOperation;
import core.basesyntax.strategy.impl.FruitReturnOperation;
import core.basesyntax.strategy.impl.FruitSupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, FruitOperation> operationsStrategies = new HashMap<>();
        operationsStrategies.put("b", new FruitBalanceOperation());
        operationsStrategies.put("s", new FruitSupplyOperation());
        operationsStrategies.put("p", new FruitPurchaseOperation());
        operationsStrategies.put("r", new FruitReturnOperation());

        StorageDao storageDao = new StorageDaoImpl();
        CsvReader reader = new CsvReaderImpl();
        CsvWriter writer = new CsvWriterImpl();
        ReportHandler reportHandler = new FruitStoreReportHandler();
        FruitTransaction fruitStoreDao = new FruitTransactionImpl();

        List<String> readData = reader.readFromFile(INPUT_PATH);
        fruitStoreDao.process(readData, operationsStrategies, storageDao);
        String report = reportHandler.makeReport(storageDao);
        writer.write(report, OUTPUT_PATH);
    }
}
