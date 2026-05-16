package core.basesyntax;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        // Просто встановлюємо початкове значення
        storage.setFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
