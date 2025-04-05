package core.basesyntax;

public class BalanceHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public BalanceHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(String fruit, int quantity) {
        int currentBalance = fruitStock.getQuantity(fruit);
        System.out.println("Current balance for " + fruit + ": " + currentBalance);
    }
}
