package service;

import java.util.HashMap;
import java.util.Map;
import service.strategy.BalanceHandler;
import service.strategy.Handler;
import service.strategy.PurchaseHandler;
import service.strategy.ReturnHandler;
import service.strategy.SupplyHandler;

public interface OperationStrategy {
    Map<String, Handler> map = new HashMap<>() {{
            put("b", new BalanceHandler());
            put("s", new SupplyHandler());
            put("p", new PurchaseHandler());
            put("r", new ReturnHandler());
        }};
    Handler get(String[] str);
}
