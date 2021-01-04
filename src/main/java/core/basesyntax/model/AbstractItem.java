package core.basesyntax.model;

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
}
