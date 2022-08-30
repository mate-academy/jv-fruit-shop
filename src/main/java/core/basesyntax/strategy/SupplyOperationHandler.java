package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Integer amountInShop = Storage.storage.get(transaction.getFruit());
        amountInShop = amountInShop + transaction.getAmount();
        Storage.storage.put(transaction.getFruit(), amountInShop);
    }
}
