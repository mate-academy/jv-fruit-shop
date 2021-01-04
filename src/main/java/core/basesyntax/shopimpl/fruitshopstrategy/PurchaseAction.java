package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractAction;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.service.Validator;

public class PurchaseAction extends AbstractAction {
    public PurchaseAction(AbstractStorage<DataRecord,
            AbstractItem> storage, ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        Validator.validate(item, amount, getStorage());
    }
}
