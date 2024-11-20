package core.basesyntax;

public class DefaultDataOperationStrategy implements DataOperationStrategy {
    @Override
    public void execute(FruitTransaction transaction, FruitDB fruitDB) {
        String type = transaction.getType();
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        switch (type) {
            case "b":
            case "s":
                fruitDB.add(fruit, quantity);
                break;
            case "p":
                fruitDB.subtract(fruit, quantity);
                break;
            case "r":
                fruitDB.add(fruit, quantity);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation type: " + type);
        }
    }
}
