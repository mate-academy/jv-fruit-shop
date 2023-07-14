package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParserService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.strategy.FruitOperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.FruitOperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Feel free to remove this class and create your own.
 */

public class Main {
    private static final int INITIAL_QUANTITY = 0;
    private static final String INPUT_FILE_PATH = "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator + "FruitStoreDB.csv";
    private static final String OUTPUT_FILE_PATH = "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator + "FruitStoreReport.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.add(new Apple(INITIAL_QUANTITY));
        storageDao.add(new Banana(INITIAL_QUANTITY));
        Map<FruitOperation, FruitOperationHandler> fruitOperationHandlerMap = new HashMap<>();
        fruitOperationHandlerMap.put(FruitOperation.BALANCE,
                new BalanceOperationHandler(storageDao));
        fruitOperationHandlerMap.put(FruitOperation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        fruitOperationHandlerMap.put(FruitOperation.RETURN,
                new ReturnOperationHandler(storageDao));
        fruitOperationHandlerMap.put(FruitOperation.SUPPLY,
                new SupplyOperationHandler(storageDao));
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        String[] fileContent = fileReaderService.readFromFile(INPUT_FILE_PATH);
        FileParserService fileParserService = new FileParserServiceImpl();
        List<FruitTransaction> fruitTransactions = fileParserService.parseFile(fileContent);
        FruitOperationStrategy fruitOperationStrategy =
                new FruitOperationStrategyImpl(fruitOperationHandlerMap);
        fruitTransactions.forEach(fruitTransaction ->
                fruitOperationStrategy.getHandler(fruitTransaction.getFruitOperation())
                        .apply(fruitTransaction));
        ReportService reportService = new ReportServiceImpl(storageDao);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_FILE_PATH, reportService.generateReport());
    }
}
