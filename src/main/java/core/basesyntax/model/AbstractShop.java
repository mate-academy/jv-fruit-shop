package core.basesyntax.model;

import core.basesyntax.model.shopstrategy.ShopActions;

public abstract class AbstractShop<R, T extends AbstractItem> {
    private final AbstractStorage<R, T> shopStorage;
    
    public AbstractShop(AbstractStorage<R, T> shopStorage) {
        this.shopStorage = shopStorage;
    }
    
    abstract void performAction(ShopActions action, T item, int amount);
    
    abstract int[] itemBalance(T... items);
}
