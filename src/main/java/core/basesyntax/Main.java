package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationsStrategy;
import core.basesyntax.strategy.OperationsStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        map.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        final OperationsStrategy operationsStrategy = new OperationsStrategyImpl(map);
        ReaderService readerService = new ReaderServiceImpl();
        final WriterService writerService = new WriterServiceImpl();
        FruitDao fruitDao = new FruitDaoImpl();
        List<FruitTransaction> fruitTransactions =
                readerService.readFromFile("src/main/resources/file.csv");
        System.out.println(fruitTransactions);
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        fruitService.recordFruits(fruitTransactions);
        System.out.println(fruitService.getAllFruits());
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationsStrategy, fruitDao);
        fruitShopService.calculateFruits(fruitTransactions);
        System.out.println(fruitService.getAllFruits());
        writerService.writeToFile(fruitService.getAllFruits());
    }
}
