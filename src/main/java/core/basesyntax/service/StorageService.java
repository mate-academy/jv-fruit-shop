package core.basesyntax.service;

import core.basesyntax.db.dto.StorageItemDTO;
import core.basesyntax.db.dto.StorageOperationDTO;
import java.util.List;

public interface StorageService {
    void clearStorage();
    StorageItemDTO getRemainder(String storageItemName);
    List<StorageItemDTO> getRemainders();
    void update(StorageOperationDTO storageOperation);
    void update (List<StorageOperationDTO> storageOperationList);
}
