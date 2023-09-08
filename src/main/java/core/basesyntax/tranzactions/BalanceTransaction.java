package core.basesyntax.tranzactions;

import core.basesyntax.stoage.Storage;

public class BalanceTransaction implements Transactions {
    @Override
    public void makeTransaction(String fruit,Integer value) {
        Storage.storage.put(fruit, value);
    }
}
