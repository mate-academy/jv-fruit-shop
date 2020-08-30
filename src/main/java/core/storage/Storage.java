package core.storage;

import core.exceptions.NoFruitsEnoughException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Storage implements FruitOperations {
    private Map<Fruit, Integer> fruitBay;
    private Set<String> operators;

    public Storage() {
        Set<String> operators = new HashSet<>();
        operators.add("s");
        operators.add("r");
        operators.add("b");
        this.operators = operators;
        this.fruitBay = new HashMap();
    }

    public boolean addOperator(String operator) {
        operators.add(operator);
        return true;
    }

    public boolean add(Fruit fruit, Integer quantity) {
        fruitBay.put(fruit, quantity);
        return true;
    }

    public boolean remove(Fruit fruit, int quantity) {
        check(fruit, quantity);
        fruitBay.put(fruit, (fruitBay.get(fruit) - quantity));
        return true;
    }

    @Override
    public boolean supply(Fruit fruit, int quantity) {
        add(fruit, quantity);
        return true;
    }

    @Override
    public boolean buy(Fruit fruit, int quantity) {
        remove(fruit, quantity);
        return true;
    }

    @Override
    public boolean refund(Fruit fruit, int quantity) {
        add(fruit, quantity);
        return true;
    }

    public void apply(Fruit fruit, int quantity, String operator) throws NoSuchMethodException {
        switch (operator) {
            case "s": {
                supply(fruit, quantity);
                break;
            }
            case "r": {
                refund(fruit, quantity);
                break;
            }
            case "b": {
                buy(fruit, quantity);
                break;
            }
            default: {
                throw new NoSuchMethodException("Operator \"" + operator + "\" is not defined");
            }
        }
    }

    public List<String> toList() {
        List<String> list = new ArrayList<>();
        Set<Fruit> fruits = fruitBay.keySet();
        for (Fruit fruit : fruits) {
            list.add(fruit.getType() + "," + fruitBay.get(fruit));
        }
        return list;
    }

    private boolean check(Fruit fruit, int quantity) {
        int has = fruitBay.get(fruit);
        if (has < quantity) {
            throw new NoFruitsEnoughException("Sorry, trying to buy " + quantity
                    + " " + fruit.getType() + ", but have only " + has);
        }
        return true;
    }
}
