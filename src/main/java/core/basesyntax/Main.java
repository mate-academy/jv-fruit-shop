package core.basesyntax;

import core.basesyntax.dao.ShopDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parser.Parser;
import core.basesyntax.parser.ParserImpl;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.ActivitiesStrategyImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.activities.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());

        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
        Parser parser = new ParserImpl();
        ShopService shopService = new ShopServiceImpl(new ShopDaoCsvImpl(), activitiesStrategy, parser);

        shopService.report();
    }
}
