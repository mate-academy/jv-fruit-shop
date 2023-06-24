package service.transaction;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public Integer calculateRemnant(Integer remnant, Integer amount) {
        return amount;
    }
}
