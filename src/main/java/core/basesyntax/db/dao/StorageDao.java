package core.basesyntax.db.dao;

import core.basesyntax.db.dto.StorageItemDto;
import java.util.List;

public interface StorageDao {
    void clearStorage();

    StorageItemDto income(StorageItemDto storageItem);

    List<StorageItemDto> income(List<StorageItemDto> storageItemList);

    StorageItemDto outcome(StorageItemDto storageItem);

    List<StorageItemDto> outcome(List<StorageItemDto> storageItemList);

    StorageItemDto setRemainder(StorageItemDto storageItem);

    List<StorageItemDto> setRemainder(List<StorageItemDto> storageItemList);

    StorageItemDto getRemainder(String storageItemName);

    List<StorageItemDto> getRemainders();
}
