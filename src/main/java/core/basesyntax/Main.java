package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.service.*;
import core.basesyntax.service_impl.*;
import core.basesyntax.strategy.FruitOperation;
import core.basesyntax.strategy.impl.FruitBalanceOperation;
import core.basesyntax.strategy.impl.FruitPurchaseOperation;
import core.basesyntax.strategy.impl.FruitReturnOperation;
import core.basesyntax.strategy.impl.FruitSupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, FruitOperation> operationsStrategies = new HashMap<>();
        operationsStrategies.put("b", new FruitBalanceOperation());
        operationsStrategies.put("s", new FruitSupplyOperation());
        operationsStrategies.put("p", new FruitPurchaseOperation());
        operationsStrategies.put("r", new FruitReturnOperation());

        final StorageDao storageDao = new StorageDaoImpl();
        final Reader reader = new CsvReaderImpl();
        final Writer writer = new CsvWriterImpl();
        final ReportHandler reportHandler = new FruitStoreReportHandler();
        final FruitStoreDao fruitStoreDao = new FruitStoreDaoImpl();

        List<String> readData = reader.read("src/main/resources/input.csv");
        fruitStoreDao.process(readData, operationsStrategies, storageDao);
        String report = reportHandler.makeReport(storageDao);
        writer.write(report, "src/main/resources/output.csv");
    }
}
