package core.basesyntax;

public class OperationsStrategyImpl implements OperationStrategy {

    public OperationsStrategyImpl(Fruits fruits) {
        this.fruits = fruits;
    }

    private final Fruits fruits;

    public int operation(String operation, String fruitType, int amount) {
        switch (operation) {
            case "b": // Balance
                return fruits.balance(fruitType, amount);
            case "s": // Supply
                return fruits.supply(fruitType, amount);
            case "p": // Purchase
                return fruits.purchase(fruitType, amount);
            case "r": // Return
                return fruits.returnFruit(fruitType, amount);
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }

    }
}
