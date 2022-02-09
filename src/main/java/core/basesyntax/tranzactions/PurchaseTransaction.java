package core.basesyntax.tranzactions;

import core.basesyntax.stoage.Storage;

public class PurchaseTransaction implements Transactions {
    @Override
    public void makeTransaction(String fruit, Integer value) {
        int count = Storage.storage.get(fruit);
        count -= value;
        Storage.storage.remove(fruit);
        Storage.storage.put(fruit, count);
    }
}
