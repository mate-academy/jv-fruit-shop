package strategy;

import java.util.Map;
import reporter.FruitShopDataReporter;

public class OperationTypes {
    private static final Map<String, OperationStrategy> operationsMap = Map.of(
            "b", new AdditionalOperationStrategy(
                    new FruitShopDataReporter().getCurrentBalanceService()),
            "s", new AdditionalOperationStrategy(
                    new FruitShopDataReporter().getCurrentBalanceService()),
            "p", new PurchaseOperationStrategy(
                    new FruitShopDataReporter().getCurrentBalanceService()),
            "r", new AdditionalOperationStrategy(
                    new FruitShopDataReporter().getCurrentBalanceService()));

    public static OperationStrategy getOperationHandler(String operation) {
        if (isOperationExist(operation)) {
            return operationsMap.get(operation);
        }
        throw new RuntimeException("There is no operation like this: " + operation);
    }

    public static boolean isOperationExist(String operation) {
        return operationsMap.containsKey(operation);
    }
}
