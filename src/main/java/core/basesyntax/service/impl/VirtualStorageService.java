package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDAO;
import core.basesyntax.db.dao.VirtualStorageDAO;
import core.basesyntax.db.dto.StorageItemDTO;
import core.basesyntax.db.dto.StorageOperationDTO;
import core.basesyntax.service.StorageService;
import java.util.List;

public class VirtualStorageService implements StorageService {
    private final StorageDAO storageDAO = new VirtualStorageDAO();
    @Override
    public void clearStorage() {
        storageDAO.clearStorage();
    }

    @Override
    public StorageItemDTO getRemainder(String storageItemName) {
        return null;
    }

    @Override
    public List<StorageItemDTO> getRemainders() {
        return null;
    }

    @Override
    public void update(StorageOperationDTO storageOperation) {

    }

    @Override
    public void update(List<StorageOperationDTO> storageOperationList) {

    }
}
