package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private List<FruitTransaction> fruitTransactionList;
    private TransactionHandler transactionHandler;

    public StorageServiceImpl(List<FruitTransaction> fruitTransactionList,
                              TransactionHandler transactionHandler) {
        this.fruitTransactionList = fruitTransactionList;
        this.transactionHandler = transactionHandler;
    }

    @Override
    public void transfer() {
        for (int i = 0; i < fruitTransactionList.size(); i++) {
            transactionHandler.get(fruitTransactionList.get(i)
                    .getOperation()).addTransaction(fruitTransactionList.get(i));
        }
    }

    @Override
    public void showReport() {
        System.out.println("fruit,quantity");
        Storage.fruits.stream()
                .map(o -> o.getFruit() + "," + o.getQuantity())
                .forEach(System.out::println);
    }
}
