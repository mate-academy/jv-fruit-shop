package core.basesyntax.db;

import core.basesyntax.db.dto.StorageItemDto;
import java.util.List;

public interface Storage {
    void clear();

    void stock(StorageItemDto storageItem);

    void withdraw(StorageItemDto storageItem);

    void setRemainder(StorageItemDto storageItem);

    StorageItemDto getRemainder(String storageItemName);

    List<StorageItemDto> getRemainders();
}
