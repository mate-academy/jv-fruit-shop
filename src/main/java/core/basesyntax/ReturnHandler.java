package core.basesyntax;

public class ReturnHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public ReturnHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(String fruit, int quantity) {
        fruitStock.add(fruit, quantity);
    }
}
