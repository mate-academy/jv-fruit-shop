package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.ServiceStrategy;
import core.basesyntax.strategy.ServiceStrategyImpl;
import core.basesyntax.strategy.operation.BalanceHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseHandler;
import core.basesyntax.strategy.operation.ReturnHandler;
import core.basesyntax.strategy.operation.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceHandler());
        operationHandlerMap.put("p", new PurchaseHandler());
        operationHandlerMap.put("r", new ReturnHandler());
        operationHandlerMap.put("s", new SupplyHandler());

        ServiceStrategy strategy = new ServiceStrategyImpl(operationHandlerMap);
        ShopService shopService = new ShopServiceImpl(new FruitDaoImpl(), strategy);
        Map<String, Integer> processedData = shopService.processData();
        FruitDao dao = new FruitDaoImpl();
        dao.saveData(processedData);
    }
}
