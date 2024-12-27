package core.basesyntax;

public class FruitStrategyImpl implements FruitStrategy {
    private final Fruit fruit;

    public FruitStrategyImpl(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public int operation(String operation, String fruitType, int amount) {
        switch (operation) {
            case "b" :
                return fruit.balance(fruitType,amount);
            case "s" :
                return fruit.supply(fruitType,amount);
            case "p" :
                return fruit.purchase(fruitType,amount);
            case "r" :
                return fruit.returnFruit(fruitType,amount);
            default:
                throw new IllegalArgumentException("Incorrect operation: " + operation);
        }
    }
}
