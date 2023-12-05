package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ActivityManager;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReaderFunction;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.WriterFunction;
import core.basesyntax.service.impl.ActivityManagerImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderFunctionImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterFunctionImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.FruitsBalancer;
import core.basesyntax.strategy.impl.FruitsPurchaser;
import core.basesyntax.strategy.impl.FruitsReturner;
import core.basesyntax.strategy.impl.FruitsSupplier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler>
            FRUIT_OPERATIONS = new HashMap<>();
    private static final FruitStorageDao FRUIT_STORAGE_DAO = new FruitStorageDaoImpl();

    public static void main(String[] args) {
        FRUIT_OPERATIONS.put(FruitTransaction.Operation.BALANCE,
                new FruitsBalancer(FRUIT_STORAGE_DAO));
        FRUIT_OPERATIONS.put(FruitTransaction.Operation.SUPPLY,
                new FruitsSupplier(FRUIT_STORAGE_DAO));
        FRUIT_OPERATIONS.put(FruitTransaction.Operation.PURCHASE,
                new FruitsPurchaser(FRUIT_STORAGE_DAO));
        FRUIT_OPERATIONS.put(FruitTransaction.Operation.RETURN,
                new FruitsReturner(FRUIT_STORAGE_DAO));

        ReaderFunction readerFunction = new ReaderFunctionImpl();
        List<String> lines = readerFunction.readFile(INPUT_PATH);

        Parser transactionService = new ParserImpl();
        List<FruitTransaction> fruitTransactions = transactionService.parse(lines);

        ActivityManager activityManager = new ActivityManagerImpl(FRUIT_OPERATIONS);
        activityManager.activateManager(fruitTransactions);

        ReportGenerator reportService = new ReportGeneratorImpl(FRUIT_STORAGE_DAO);
        String report = reportService.generateReport();

        WriterFunction writerService = new WriterFunctionImpl();
        writerService.writeFile(OUTPUT_PATH, report);
    }
}
