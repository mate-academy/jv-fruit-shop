package core.basesyntax.strategy;

import core.basesyntax.Operations;
import core.basesyntax.model.Fruit;
import core.basesyntax.operationHandlers.BalanceOperationHandler;
import core.basesyntax.operationHandlers.PurchaseOperationHandler;
import core.basesyntax.operationHandlers.ReturnOperationHandler;
import core.basesyntax.operationHandlers.SupplyOperationHandler;
import core.basesyntax.storage.Storage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FruitStrategyImpl implements FruitStrategy {
    private Storage storage;
    private Map<Operations, BiFunction<String,Integer,Integer>> operationMap;
    private BalanceOperationHandler balance;
    private PurchaseOperationHandler purchase;
    private ReturnOperationHandler returnFruit;
    private SupplyOperationHandler supply;

    public FruitStrategyImpl() {
        storage = new Storage();
        operationMap = new HashMap<>();
        balance = new BalanceOperationHandler(storage);
        purchase = new PurchaseOperationHandler(storage);
        returnFruit = new ReturnOperationHandler(storage);
        supply = new SupplyOperationHandler(storage);

        operationMap.put(Operations.B, (fruitType, amount) -> balance.balance(fruitType, amount));
        operationMap.put(Operations.S, (fruitType, amount) -> supply.supply(fruitType, amount));
        operationMap.put(Operations.P, (fruitType, amount) -> purchase.purchase(fruitType, amount));
        operationMap.put(Operations.R, (fruitType, amount) -> returnFruit.returnFruit(fruitType, amount));
    }

    @Override
    public int operation(String operation, String fruitType, int amount) {

        Operations op = Operations.valueOf(operation.toUpperCase());

        BiFunction<String, Integer, Integer> stringIntegerIntegerBiFunction =
                operationMap.get(op);
        if (stringIntegerIntegerBiFunction == null) {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        return stringIntegerIntegerBiFunction.apply(fruitType,amount);
        /*switch (operation) {
            case "b" :
                return fruit.balance(fruitType,amount);
            case "s" :
                return fruit.supply(fruitType,amount);
            case "p" :
                return fruit.purchase(fruitType,amount);
            case "r" :
                return fruit.returnFruit(fruitType,amount);
            default:
                throw new IllegalArgumentException("Incorrect operation: " + operation);*/
    }
}

