package core.basesyntax.model;

public class ItemActivities {
    private final Activities activities;
    private final String item;
    private final int quantity;

    public ItemActivities(Activities activities, String item, int quantity) {
        this.activities = activities;
        this.item = item;
        this.quantity = quantity;
    }

    public Activities getOperation() {
        return activities;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
