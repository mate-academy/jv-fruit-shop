package core.basesyntax;

import core.basesyntax.domain.Fruit;
import core.basesyntax.service.*;
import core.basesyntax.service.operation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShopApplication {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> readLines = fileService.read("fruits.csv");
        DataConverterService dataConverterService = new DataConverterImpl();
        List<Fruit> convertedFruits = dataConverterService.convertToFruit(readLines);
        Map<Fruit.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Fruit.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Fruit.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Fruit.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Fruit.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(convertedFruits);
    }
}
