package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;


import static core.basesyntax.db.Storage.storage;

public class StorageService implements IStorageService {
    private final List<FruitTransaction> fruitTransactionsList;

    public StorageService() {
        fruitTransactionsList = new ArrayList<>();
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int tmp = 0;
        switch (fruitTransaction.getOperation()) {
            case BALANCE:
            case SUPPLY:
            case RETURN:
                if (storage.containsKey(fruitTransaction.getFruit())){
                    tmp = storage.get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity();
                } else{
                    tmp = fruitTransaction.getQuantity();
                }
                break;
            case PURCHASE:
                tmp = storage.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity();
                break;
        }
        storage.put(fruitTransaction.getFruit(), tmp);
        fruitTransactionsList.add(fruitTransaction);
    }
}
