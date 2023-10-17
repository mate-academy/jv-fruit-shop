package core.basesyntax.db.dao;

import core.basesyntax.db.dto.StorageItemDTO;
import core.basesyntax.db.dto.StorageOperationDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualStorageDAO implements StorageDAO{
    private final Map<String, Double> storage = new HashMap<>();

    @Override
    public void clearStorage() {
        storage.clear();
    }

    @Override
    public StorageItemDTO getRemainder(String name) {
        return null;
    }

    @Override
    public List<StorageItemDTO> getRemainders() {
        return null;
    }

    @Override
    public void update(StorageOperationDTO operation) {


    }

    @Override
    public void update(List<StorageOperationDTO> operationList) {

    }
}
