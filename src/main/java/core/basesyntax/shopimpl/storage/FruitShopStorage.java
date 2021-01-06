package core.basesyntax.shopimpl.storage;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.fruitshopstrategy.FruitShopActionHandler;
import java.util.List;

public class FruitShopStorage extends AbstractStorage<DataRecord, AbstractItem> {
    @Override
    public void initStorage(List<DataRecord> history) {
        FruitShopActionHandler handler = new FruitShopActionHandler();
        for (DataRecord record : history) {
            handler.getAction(record.getAction())
                    .apply(record.getItem(), record.getAmount(), getStorage());
        }
    }
}
