package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.shopstrategy.AbstractAction;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.service.Validator;
import core.basesyntax.shopimpl.storage.FruitShopStorage;

public class PurchaseAction extends AbstractAction {
    public PurchaseAction(FruitShopStorage storage, FruitShopDao shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        Validator.validate(item, amount, getStorage());
    }
}
