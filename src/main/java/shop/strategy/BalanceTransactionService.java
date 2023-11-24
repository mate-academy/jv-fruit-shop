package shop.strategy;

import shop.model.FruitTransaction;

public class BalanceTransactionService implements TransactionService {
    @Override
    public void process(FruitTransaction transaction) {
        dao.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
