package core.basesyntax.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class WarehouseImpl implements Warehouse {
    private final Map<String, Integer> remains;
    private final List<FruitTransaction> dayOperations;

    public WarehouseImpl(List<FruitTransaction> dayOperations) {
        this.remains = new HashMap<>();
        this.dayOperations = new ArrayList<>();
        for (FruitTransaction dayOperation : dayOperations) {
            operationHandler(dayOperation);
        }
    }

    @Override
    public Map<String, Integer> getRemains() {
        return remains;
    }

    @Override
    public List<FruitTransaction> getDayOperations() {
        return dayOperations;
    }

    @Override
    public boolean operationHandler(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperation()) {
            case BALANCE: {
                setRestOfFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
                return true;
            }
            case PURCHASE: {
                sell(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
                return true;
            }
            case SUPPLY: {
                bye(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
                return true;
            }
            case RETURN: {
                returnFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private int sell(String fruit, int qte) {
        Integer rest = remains.get(fruit);
        if (rest == null || rest < qte) {
            throw new NoSuchElementException("Not enough quantity of " + fruit + " on the rest");
        }
        dayOperations.add(warehouseOperation(
                FruitTransaction.Operation.PURCHASE, fruit, qte));
        remains.put(fruit, rest - qte);
        return remains.get(fruit);
    }

    private int bye(String fruit, int qte) {
        Integer rest = remains.get(fruit);
        if (rest == null) {
            rest = 0;
        }
        dayOperations.add(warehouseOperation(
                FruitTransaction.Operation.SUPPLY, fruit, qte));
        remains.put(fruit, rest + qte);
        return remains.get(fruit);
    }

    private int returnFruit(String fruit, int qte) {
        Integer rest = remains.get(fruit);
        if (rest == null) {
            rest = 0;
        }
        dayOperations.add(warehouseOperation(
                FruitTransaction.Operation.RETURN, fruit, qte));
        remains.put(fruit, rest + qte);
        return remains.get(fruit);
    }

    private int setRestOfFruit(String fruit, int qte) {
        dayOperations.add(warehouseOperation(
                FruitTransaction.Operation.BALANCE, fruit, qte));
        remains.put(fruit, qte);
        return remains.get(fruit);
    }

    private FruitTransaction warehouseOperation(FruitTransaction.Operation operation,
                                                String fruit, int qte) {
        return new FruitTransaction(operation, fruit, qte);
    }

}
