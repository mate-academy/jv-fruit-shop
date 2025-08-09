package core.basesyntax.strategy;

public class PurchaseOperation implements OperationHandler {

    @Override
    public int apply(int currentQuantity, int transactionQuantity) {
        int newQuantity = currentQuantity - transactionQuantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Purchase operation resulted in negative balance! "
                    + "Current: " + currentQuantity + ", Purchased: " + transactionQuantity);
        }
        return newQuantity;
    }
}
