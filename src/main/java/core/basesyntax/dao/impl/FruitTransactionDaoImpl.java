package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitTranzactionDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTranzactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruitShopData.add(fruitTransaction);
    }
    
    @Override
    public FruitTransaction get(int index) {
        return Storage.fruitShopData.get(index);
    }
    
    @Override
    public int getSizeStorage() {
        return Storage.fruitShopData.size();
    }
}
