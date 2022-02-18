package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_PATH
            = "src/main/java/core/basesyntax/resource/input.csv";
    private static final String REPORT_FILE_PATH
            = "src/main/java/core/basesyntax/resource/report.csv";
    private static final FruitDao FRUIT_DAO = new FruitDaoImpl();
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final TransactionService transactionService = new TransactionServiceImpl();
    private static final Map<FruitTransaction.Operation,
            OperationHandler> fruitServiceMap = new HashMap<>();

    static {
        fruitServiceMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        fruitServiceMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        fruitServiceMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        fruitServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
    }

    public static void main(String[] args) {
        List<String> rawDataFromFile = fileReaderService.read(SOURCE_FILE_PATH);
        List<FruitTransaction> fruitsTransactionList
                = transactionService.processData(rawDataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitServiceMap);
        FruitService fruitService = new FruitServiceImpl(FRUIT_DAO, operationStrategy);
        fruitService.setDataToStorage(fruitsTransactionList);
        List<Fruit> fruitsFromStorage = FRUIT_DAO.getAll();
        fileWriterService.write(REPORT_FILE_PATH, fruitsFromStorage);
    }
}
