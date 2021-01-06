package core.basesyntax.model;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDto;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import java.util.Map;

public abstract class AbstractShop<R, I extends AbstractItem> {
    private final AbstractStorage<R, I> shopStorage;
    private final ShopDto<R> shopDto;
    
    public AbstractShop(AbstractStorage<R, I> shopStorage, ShopDto<R> shopDto) {
        if (shopDto == null || shopStorage == null) {
            throw new RuntimeException("NonNull arguments expected");
        }
        this.shopStorage = shopStorage;
        this.shopDto = shopDto;
    }
    
    public abstract void performAction(ShopTransactionsType action, I item, int amount);
    
    public Map<I, Integer> getShopStorage() {
        return shopStorage.getStorage();
    }
    
    public ShopDto<R> getShopDao() {
        return shopDto;
    }
}
