package core.basesyntax.model;

import java.util.Objects;

public abstract class AbstractItem {
    private String itemName;
    
    public AbstractItem(String itemName) {
        this.itemName = itemName;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractItem)) return false;
        AbstractItem that = (AbstractItem) o;
        return itemName.equals(that.itemName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }
}
