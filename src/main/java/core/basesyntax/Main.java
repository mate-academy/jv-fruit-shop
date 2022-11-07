package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.DataTransactionParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.DataTransactionParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.impl.BalanceOperationImpl;
import core.basesyntax.strategy.operation.impl.PurchaseOperationImpl;
import core.basesyntax.strategy.operation.impl.ReturnOperationImpl;
import core.basesyntax.strategy.operation.impl.SupplyOperationImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static String fromFile = "src/main/resources/input.csv";
    private static String toFile = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FruitService fruitService = new FruitServiceImpl();
        Map<String, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(Operation.BALANCE.getOperation(),
                new BalanceOperationImpl());
        operationServiceMap.put(Operation.SUPPLY.getOperation(),
                new SupplyOperationImpl());
        operationServiceMap.put(Operation.PURCHASE.getOperation(),
                new PurchaseOperationImpl());
        operationServiceMap.put(Operation.RETURN.getOperation(),
                new ReturnOperationImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationServiceMap);
        DataTransactionParser dataTransactionParser =
                new DataTransactionParserImpl(operationStrategy);
        String dataFromFile = fruitService.readData(fromFile);
        String report = fruitService.processFruitsData(
                operationServiceMap, dataFromFile, dataTransactionParser);
        fruitService.createResultFile(report, toFile);
    }
}

