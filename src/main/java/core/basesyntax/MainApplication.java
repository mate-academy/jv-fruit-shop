package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnSupplyBalanceHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.List;

public class MainApplication {
    private static final String INPUT_FILE = "src/main/resources/database.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";
    private static List<OperationHandler> handlers;

    private static void initializeHandlersList() {
        handlers = List.of(
                new ReturnSupplyBalanceHandler(),
                new PurchaseOperationHandler());
    }

    public static void main(String[] args) {
        initializeHandlersList();
        ReaderService reader = new ReaderServiceImpl();
        FruitDao fruitDao = new FruitDaoImpl();
        TransactionStrategy strategy = new TransactionStrategyImpl(handlers);
        FruitService fruitService = new FruitServiceImpl(reader, fruitDao, strategy);
        fruitService.updateAll(fruitService.get(INPUT_FILE));
        WriterService reportWriter = new WriterServiceImpl();
        reportWriter.write(OUTPUT_FILE);
    }
}
