package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private List<FruitTransaction> fruitTransactionList;
    private OperationStrategy transactionHandler;

    public StorageServiceImpl(List<FruitTransaction> fruitTransactionList,
                              OperationStrategy transactionHandler) {
        this.fruitTransactionList = fruitTransactionList;
        this.transactionHandler = transactionHandler;
    }

    @Override
    public void transfer() {
        for (int i = 0; i < fruitTransactionList.size(); i++) {
            transactionHandler.get(fruitTransactionList.get(i)
                    .getByCode()).addTransaction(fruitTransactionList.get(i));
        }
    }

    @Override
    public void showReport() {
        System.out.println("fruit,quantity");
        Storage.remnantsOfGoods.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "," + entry.getValue());
                });
    }
}
