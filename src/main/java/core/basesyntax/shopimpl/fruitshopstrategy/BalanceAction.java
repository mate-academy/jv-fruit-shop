package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.AbstractStorage;
import core.basesyntax.model.shopstrategy.ShopAction;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.service.IODataFileService;
import java.util.Map;

public class BalanceAction implements ShopAction {
    private AbstractStorage<DataRecord, AbstractItem> storage;
    
    public BalanceAction(AbstractStorage<DataRecord, AbstractItem> storage) {
        this.storage = storage;
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        IODataFileService.buildReport(storage.getStorage(),
                "src/main/java/core/basesyntax/shopimpl/Report.txt");
    }
    
    public Map<AbstractItem, Integer> getStorage() {
        return storage.getStorage();
    }
}
