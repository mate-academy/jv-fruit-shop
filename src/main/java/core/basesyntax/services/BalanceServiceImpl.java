package core.basesyntax.services;

import core.basesyntax.dao.TransactionsDao;
import core.basesyntax.dao.TransactionsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;
import java.util.Map;

public class BalanceServiceImpl implements BalanceService {
    private TransactionsDao transactionsDao = new TransactionsDaoImpl();

    @Override
    public void balance(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            if (transaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
                continue;
            }
            TransactionStrategy strategy = new TransactionStrategy();
            TransactionHandler transactionHandler =
                    strategy.getTransactionService(transaction.getOperation());
            for (Map.Entry<String, Integer> entry: transactionsDao.get().entrySet()) {
                if (entry.getKey().equals(transaction.getFruit())) {
                    entry.setValue(transactionHandler
                            .dayResult(entry.getValue(),transaction.getQuantity()));
                }
            }
        }
    }
}
