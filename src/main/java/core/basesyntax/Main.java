package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.DailyReport;
import core.basesyntax.service.impl.DailyReportImp;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.service.impl.FruitTransactionImpl;
import core.basesyntax.service.impl.OperationStrategy;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(initializeHandlers());
        FruitTransaction fruitTransaction = new FruitTransactionImpl(operationStrategy);
        for (String line : fruitTransaction.processBalance()) {
            System.out.println(line);
        }
        System.out.println("\n");
        for (String line : fruitTransaction.processPurchase()) {
            System.out.println(line);
        }
        System.out.println("\n");
        for (String line : fruitTransaction.processReturn()) {
            System.out.println(line);
        }
        System.out.println("\n");
        for (String line : fruitTransaction.processSupply()) {
            System.out.println(line);
        }
        System.out.println("\n");
        FruitDao fruitDao = new FruitDaoImpl();
        DailyReport operationReport = new DailyReportImp(fruitDao);
        List<String> currentReport = operationReport.report();;
        System.out.println("Current Report:");
        for (String line : currentReport) {
            System.out.println(line);
        }
    }

    private static Map<Fruit.Operation, OperationHandler> initializeHandlers() {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<Fruit.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Fruit.Operation.BALANCE, new BalanceHandler(fruitDao));
        handlers.put(Fruit.Operation.SUPPLY, new SupplyHandler(fruitDao));
        handlers.put(Fruit.Operation.PURCHASE, new PurchaseHandler(fruitDao));
        handlers.put(Fruit.Operation.RETURN, new ReturnHandler(fruitDao));
        return handlers;
    }
}
