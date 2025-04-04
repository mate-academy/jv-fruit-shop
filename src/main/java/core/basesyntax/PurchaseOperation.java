package core.basesyntax;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = Storage.getFruitQuantity(transaction.getFruit());
        if (currentQuantity < transaction.getAmount()) {
            throw new RuntimeException("Not enough " + transaction.getFruit()
                    + " in stock. Available: "
                    + currentQuantity + ", trying to purchase: " + transaction.getAmount());
        }
        Storage.removeFruit(transaction.getFruit(), transaction.getAmount());
    }
}
