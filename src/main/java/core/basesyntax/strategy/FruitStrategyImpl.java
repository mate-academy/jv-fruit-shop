package core.basesyntax.strategy;

import core.basesyntax.Operation;
import core.basesyntax.operationhandlers.BalanceOperationHandler;
import core.basesyntax.operationhandlers.PurchaseOperationHandler;
import core.basesyntax.operationhandlers.ReturnOperationHandler;
import core.basesyntax.operationhandlers.SupplyOperationHandler;
import core.basesyntax.storage.Storage;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FruitStrategyImpl implements FruitStrategy {
    private Storage storage;
    private Map<Operation, BiFunction<String,Integer,Integer>> operationMap;
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

        operationMap.put(Operation.BALANCE, (fruitType, amount)
                -> balance.balance(fruitType, amount));
        operationMap.put(Operation.SUPPLY, (fruitType, amount)
                -> supply.supply(fruitType, amount));
        operationMap.put(Operation.PURCHASE, (fruitType, amount)
                -> purchase.purchase(fruitType, amount));
        operationMap.put(Operation.RETURN, (fruitType, amount)
                -> returnFruit.returnFruit(fruitType, amount));
    }

    @Override
    public int operation(String operation, String fruitType, int amount) {
        try {
            Operation op = Operation.getOperation(operation);
            BiFunction<String, Integer, Integer> stringIntegerIntegerBiFunction = operationMap.get(op);
            if (stringIntegerIntegerBiFunction == null) {
                throw new IllegalArgumentException("Invalid operation: " + operation);
            }
            return stringIntegerIntegerBiFunction.apply(fruitType, amount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation code: " + operation + ". Please use a valid operation code.", e);
        }
    }
}
