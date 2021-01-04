package core.basesyntax.shopimpl.entity;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopActions;

public class DataRecord {
    private ShopActions action;
    private AbstractItem item;
    private Integer amount;
    
    public DataRecord(ShopActions action, AbstractItem item, Integer amount) {
        this.action = action;
        this.item = item;
        this.amount = amount;
    }
    
    public ShopActions getAction() {
        return action;
    }
    
    public AbstractItem getItem() {
        return item;
    }
    
    public Integer getAmount() {
        return amount;
    }
}
