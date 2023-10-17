package core.basesyntax.db.dto;

public class StorageOperationDTO {
    private final String type;
    private final StorageItemDTO goods;

    public StorageOperationDTO(String type, StorageItemDTO goods) {
        this.type = type;
        this.goods = goods;
    }

    public String getType() {
        return type;
    }

    public StorageItemDTO getGoods() {
        return goods;
    }
}
