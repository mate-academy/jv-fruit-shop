package core.basesyntax.service;

import static core.basesyntax.db.Storage.storage;

public class StorageService implements IStorageService {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int tmp;
        switch (fruitTransaction.getOperation()) {
            case BALANCE:
            case SUPPLY:
            case RETURN:
                if (storage.containsKey(fruitTransaction.getFruit())) {
                    tmp = storage.get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity();
                } else {
                    tmp = fruitTransaction.getQuantity();
                }
                break;
            case PURCHASE:
                tmp = storage.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity();
                break;
            default:
                throw new RuntimeException("Unknown operation");
        }
        storage.put(fruitTransaction.getFruit(), tmp);
    }
}
