package core.basesyntax.service;

import core.basesyntax.db.dto.StorageItemDto;
import core.basesyntax.db.dto.StorageOperationDto;
import java.util.List;

public interface StorageService {
    void clearStorage();

    StorageItemDto getRemainder(String storageItemName);

    List<StorageItemDto> getRemainders();

    void update(StorageOperationDto storageOperation);

    void update(List<StorageOperationDto> storageOperationList);
}
