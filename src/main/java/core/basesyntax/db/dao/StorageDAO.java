package core.basesyntax.db.dao;

import core.basesyntax.db.dto.StorageItemDTO;
import core.basesyntax.db.dto.StorageOperationDTO;
import java.util.List;

public interface StorageDAO {
    void clearStorage();
    StorageItemDTO getRemainder(String name);
    List<StorageItemDTO> getRemainders();
    void update(StorageOperationDTO operation);
    void update(List<StorageOperationDTO> operationList);
}
