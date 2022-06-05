package core.basesyntax.service;

import core.basesyntax.model.ProductTransaction;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Queue;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public Queue<ProductTransaction> read(Path fileName) {
        // TODO do read from file
        Queue<ProductTransaction> productTransactions = new LinkedList<>();
        productTransactions.add(
                new ProductTransaction(
                        ProductTransaction.Operation.BALANCE, "banana", 20));
        productTransactions.add(
                new ProductTransaction(
                        ProductTransaction.Operation.BALANCE, "apple", 100));
        productTransactions.add(
                new ProductTransaction(
                        ProductTransaction.Operation.SUPPLY, "banana", 100));
        productTransactions.add(
                new ProductTransaction(
                        ProductTransaction.Operation.PURCHASE, "banana", 13));
        productTransactions.add(
                new ProductTransaction(
                        ProductTransaction.Operation.RETURN, "apple", 10));
        productTransactions.add(
                new ProductTransaction(
                        ProductTransaction.Operation.PURCHASE, "apple", 20));
        productTransactions.add(
                new ProductTransaction(
                        ProductTransaction.Operation.PURCHASE, "banana", 5));
        productTransactions.add(
                new ProductTransaction(
                        ProductTransaction.Operation.SUPPLY, "banana", 50));
        return productTransactions;
    }
}
