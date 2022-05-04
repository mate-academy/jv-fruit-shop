import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
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
        final String inputFile = "src//main//resources//before.csv";
        final String outputFile = "src//main//resources//after.csv";

        Map<FruitTransaction.Operation, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl());
        strategyMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl());

        StrategyService strategyService = new StrategyServiceImpl(strategyMap);
        FruitService fruitService = new FruitServiceImpl(strategyService);

        fruitService.processData(inputFile);
        fruitService.saveReport(outputFile);
    }
}
