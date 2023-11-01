import java.util.HashMap;
import java.util.Map;
import strategy.FruitStrategy;
import strategy.handlers.BalanceHandler;
import strategy.handlers.PurchaseHandler;
import strategy.handlers.ReturnHandler;
import strategy.handlers.SupplyHandler;

public class Main {
    public static void main(String[] args) {
        Map<String, FruitStrategy> strategyMap = new HashMap<>();
        FruitStrategy balanceHandler = new BalanceHandler();
        FruitStrategy purchaseHandler = new PurchaseHandler();
        FruitStrategy returnHandler = new ReturnHandler();
        FruitStrategy supplyHandler = new SupplyHandler();
        strategyMap.put("b",balanceHandler);
        strategyMap.put("p",purchaseHandler);
        strategyMap.put("r",returnHandler);
        strategyMap.put("s",supplyHandler);
    }
}
