package core.basesyntax;

public class SupplyHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public SupplyHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(String fruit, int quantity) {
        fruitStock.add(fruit, quantity);
    }
}
