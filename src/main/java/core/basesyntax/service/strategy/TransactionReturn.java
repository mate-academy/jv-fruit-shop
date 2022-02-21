package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;

public class TransactionReturn implements TransactionHandler {

    @Override
  public void store(String[] oneTransaction) {
        if (Storage.storage.get(oneTransaction[FRUIT_INDEX]) == null) {
            Storage.storage.put(oneTransaction[FRUIT_INDEX],
                    Integer.parseInt(oneTransaction[FRUIT_QUANTITY]));
        } else {
            Storage.storage.put(oneTransaction[FRUIT_INDEX],
                    Storage.storage.get(oneTransaction[FRUIT_INDEX])
                    + Integer.parseInt(oneTransaction[FRUIT_QUANTITY]));
        }
    }
}
