package core.basesyntax;


import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.strategy.activities.ActivitiesHandler;
import core.basesyntax.strategy.activities.BalanceActivitiesHandler;
import core.basesyntax.strategy.activities.PurchaseActivitiesHandler;
import core.basesyntax.strategy.activities.ReturnActivitiesHandler;
import core.basesyntax.strategy.activities.SupplyActivitiesHandler;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.FruitStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static ReadService readService = new ReadServiceImpl();
    private static ProcessService processService = new ProcessServiceImpl();

    public static void main(String[] args) {


//        Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
//        activitiesHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceActivitiesHandler());
//        activitiesHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseActivitiesHandler());
//        activitiesHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyActivitiesHandler());
//        activitiesHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnActivitiesHandler());
//
//        FruitStrategy fruitStrategy = new FruitStrategyImpl(activitiesHandlerMap);
//        FruitService fruitService = new FruitServiceImpl(fruitStrategy);

        List<String> strings = readService.readFromFile("src/main/file.csv");
        List<FruitTransaction> process = processService.process(strings);

    }

}
