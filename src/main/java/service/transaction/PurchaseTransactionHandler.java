package service.transaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public Integer calculateRemnant(Integer remnant, Integer amount) {
        return remnant - amount;
    }
}
