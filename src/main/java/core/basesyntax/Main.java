package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.impl.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWorkerService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileWorkerServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.DefaultOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_READ_FROM = "src/main/resources/data.csv";
    private static final String BALANCE_OPERATION = "BALANCE";
    private static final String PURCHASE_OPERATION = "PURCHASE";
    private static final String SUPPLY_OPERATION = "SUPPLY";
    private static final String RETURN_OPERATION = "RETURN";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put(BALANCE_OPERATION, new BalanceOperationHandler());
        handlers.put(PURCHASE_OPERATION, new PurchaseOperationHandler());
        handlers.put(SUPPLY_OPERATION, new SupplyOperationHandler());
        handlers.put(RETURN_OPERATION, new ReturnOperationHandler());
        OperationHandlerStrategy operationStrategy =
                new OperationHandlerStrategy(handlers, new DefaultOperationHandler());

        FileWorkerService fileWorker = new FileWorkerServiceImpl();
        List<String> fileLines = fileWorker.readFromFile(FILE_READ_FROM);

        TransactionService transactionService = new TransactionServiceImpl();
        List<FruitTransaction> transactions = transactionService.createTransactions(fileLines);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.handleTransactions(transactions);

        ProductDao productDao = new ProductDaoImpl();
        fileWorker.createReport(productDao.getAllProducts());
    }
}
