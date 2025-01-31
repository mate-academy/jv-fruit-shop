package dao;

import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import model.FruitTransaction;
import strategy.BalanceStrategy;
import strategy.PurchaseStrategy;
import strategy.ReturnStrategy;
import strategy.SupplyStrategy;
import strategy.TransactionStrategy;

public class TransactionDaoImpl implements TransactionsDao {

    private final Map<FruitTransaction.Operation, TransactionStrategy> operationHandlers
            = new HashMap<>();

    public TransactionDaoImpl() {
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceStrategy());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyStrategy());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategy());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnStrategy());
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.transactions;
    }

    @Override
    public void processTransaction(FruitTransaction transaction) {
        FruitTransaction fruit = findOrCreateFruit(transaction);
        operationHandlers.getOrDefault(transaction.getOperation(), (f, t) -> {
            throw new IllegalArgumentException("Unknown operation: " + t.getOperation());
        }).apply(fruit, transaction);
    }

    @Override
    public void updateTransactionInfo(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }

    @Override
    public FruitTransaction getTransactionByName(String fruitName) {
        return Storage.transactions.stream()
                .filter(transaction -> transaction.getFruit().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public FruitTransaction findOrCreateFruit(FruitTransaction transaction) {
        return Optional.ofNullable(getTransactionByName(transaction.getFruit()))
                .orElseGet(() -> {
                    updateTransactionInfo(transaction);
                    return transaction;
                });
    }
}
