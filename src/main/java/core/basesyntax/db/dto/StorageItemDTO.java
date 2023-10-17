package core.basesyntax.db.dto;

public class StorageItemDTO {
    private final String name;
    private final double qty;

    public StorageItemDTO(String name, double qty) {
        this.name = name;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public double getQty() {
        return qty;
    }
}
