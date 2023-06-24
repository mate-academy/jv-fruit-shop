package service.transaction;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public Integer calculateRemnant(Integer remnant, Integer amount) {
        return remnant + amount;
    }
}
