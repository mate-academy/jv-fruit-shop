package core.basesyntax;

public class PurchaseHandler implements OperationHandler {

    private final FruitStock fruitStock;

    public PurchaseHandler(FruitStock fruitStock) {
        this.fruitStock = fruitStock;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        int currentBalance = fruitStock.getFruitQuantity(fruit);

        if (currentBalance >= quantity) {
            fruitStock.updateFruitQuantity(fruit, currentBalance - quantity);
            System.out.println("Покупка успішно виконана: " + quantity + " " + fruit);
        } else {
            System.out.println("Помилка: недостатньо фруктів для покупки " + fruit);
        }
    }
}
