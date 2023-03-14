package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoCsvImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class MainApplication {
    private static final String INPUT_FILE = "database.csv";
    private static final String OUTPUT_FILE = "report.csv";
    private static List<OperationHandler> handlers;
    private static TransactionDao transactionDao;
    private static FruitDao fruitDao;
    private static TransactionStrategy strategy;
    private static FruitService fruitService;
    private static WriterService reportWriter;

    private static void initializeHandlersList() {
        handlers = List.of(
                new ReturnOperationHandler(),
                new BalanceOperationHandler(),
                new PurchaseOperationHandler(),
                new SupplyOperationHandler());
    }

    public static void main(String[] args) {
        initializeHandlersList();
        transactionDao = new TransactionDaoCsvImpl();
        fruitDao = new FruitDaoImpl();
        strategy = new TransactionStrategyImpl(handlers);
        fruitService = new FruitServiceImpl(transactionDao, fruitDao, strategy);
        fruitService.update(fruitService.get(INPUT_FILE));
        reportWriter = new WriterServiceImpl();
        reportWriter.write(OUTPUT_FILE);
    }
}
