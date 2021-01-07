package core.basesyntax.shopimpl.entity;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import java.util.Objects;

public class DataRecord {
    private ShopTransactionsType action;
    private AbstractItem item;
    private Integer amount;
    
    public DataRecord(ShopTransactionsType action, AbstractItem item, Integer amount) {
        if (action == null || item == null || amount == null) {
            throw new RuntimeException("Require non null arguments");
        }
        this.action = action;
        this.item = item;
        this.amount = amount;
    }
    
    public ShopTransactionsType getAction() {
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
}
