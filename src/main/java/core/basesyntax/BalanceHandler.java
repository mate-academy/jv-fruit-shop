package core.basesyntax;

public class BalanceHandler implements OperationHandler {
    private final FruitStock fruitStock;

    public BalanceHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        fruitStock.add(fruit, quantity);
        System.out.println("Баланс для " + fruit + ": " + quantity);
    }
}
