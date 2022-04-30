import java.util.HashMap;
import java.util.Map;
import model.Operation;
import service.FruitService;
import service.impl.FruitServiceImpl;
import strategy.OperationHandler;
import strategy.StrategyService;
import strategy.impl.BalanceOperationImpl;
import strategy.impl.PurchaseOperationImpl;
import strategy.impl.ReturnOperationImpl;
import strategy.impl.StrategyServiceImpl;
import strategy.impl.SupplyOperationImpl;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new BalanceOperationImpl());
        strategyMap.put(Operation.SUPPLY, new SupplyOperationImpl());
        strategyMap.put(Operation.PURCHASE, new PurchaseOperationImpl());
        strategyMap.put(Operation.RETURN, new ReturnOperationImpl());

        StrategyService strategyService = new StrategyServiceImpl(strategyMap);
        FruitService fruitService = new FruitServiceImpl(strategyService);

        fruitService.read("src//main//resources//before.csv");
        fruitService.write("src//main//resources//after.csv");
    }
}
