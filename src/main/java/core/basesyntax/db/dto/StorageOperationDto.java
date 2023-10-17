package core.basesyntax.db.dto;

public class StorageOperationDto {
    private final String type;
    private final StorageItemDto storageItem;

    public StorageOperationDto(String type, StorageItemDto storageItem) {
        this.type = type;
        this.storageItem = storageItem;
    }

    public String getType() {
        return type;
    }

    public StorageItemDto getStorageItem() {
        return storageItem;
    }
}
