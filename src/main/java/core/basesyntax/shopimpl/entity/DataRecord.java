package core.basesyntax.shopimpl.entity;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;

public class DataRecord {
    private ShopTransactionsTypes action;
    private AbstractItem item;
    private Integer amount;
    
    public DataRecord(ShopTransactionsTypes action, AbstractItem item, Integer amount) {
        this.action = action;
        this.item = item;
        this.amount = amount;
    }
    
    public ShopTransactionsTypes getAction() {
        return action;
    }
    
    public AbstractItem getItem() {
        return item;
    }
    
    public Integer getAmount() {
        return amount;
    }
}
