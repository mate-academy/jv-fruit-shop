package core.basesyntax.model;

import core.basesyntax.model.shopstrategy.ShopActions;

public abstract class AbstractShop<T> {
    private final AbstractStorage<T> shopStorage;
    
    public AbstractShop(AbstractStorage<T> shopStorage) {
        this.shopStorage = shopStorage;
    }
    
    abstract void performAction(ShopActions action, T item, int amount);
    
    abstract int[] itemBalance(T... items);
}
