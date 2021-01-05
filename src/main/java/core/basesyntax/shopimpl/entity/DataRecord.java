package core.basesyntax.shopimpl.entity;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import java.util.Objects;

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DataRecord)) {
            return false;
        }
        DataRecord that = (DataRecord) o;
        return action == that.action && item.equals(that.item) && amount.equals(that.amount);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(action, item, amount);
    }
    
    @Override
    public String toString() {
        return "DataRecord{"
               + "action=" + action
               + ", item=" + item
               + ", amount=" + amount
               + '}';
    }
}
