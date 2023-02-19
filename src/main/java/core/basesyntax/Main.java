package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.BalanceOperationImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReturnOperationImpl;
import core.basesyntax.service.impl.SupplyOperationImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {

        StorageDao storageDao = new StorageDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl(storageDao));
        operations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl(storageDao));
        operations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl(storageDao));
        operations.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl(storageDao));

        String inputFilePath = "src/main/resources/input.csv";
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromCsvFile(inputFilePath);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processDailyActivities(data);

        String report = storageDao.generateReport();

        String outputFilePath = "src/main/resources/output.csv";
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(outputFilePath, report);

    }
}
