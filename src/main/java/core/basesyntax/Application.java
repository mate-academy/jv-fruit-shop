package core.basesyntax;

import core.basesyntax.model.FruitShop;
import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.AdditionStrategy;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.SubtractionStrategy;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new AdditionStrategy());
        strategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        strategyMap.put(Operation.RETURN, new AdditionStrategy());
        strategyMap.put(Operation.PURCHASE, new SubtractionStrategy());
        FruitShop fruitShop = new FruitShop(strategyMap);
        fruitShop.generateBalance("src/main/resources/data_for_monday.csv");
        fruitShop.generateReport("report.csv");
    }
}
