package service.transaction;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public Integer calculateRemnant(Integer remnant, Integer amount) {
        return remnant + amount;
    }
}
