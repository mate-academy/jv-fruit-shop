package core.basesyntax.db;

import core.basesyntax.db.dto.StorageItemDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualStorage implements Storage {
    private final HashMap<String, Double> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void income(StorageItemDto storageItem) {
        double newQty = storage.containsKey(storageItem.getName())
                                ? storage.get(storageItem.getName()) + storageItem.getQty()
                                : 0;
        storage.put(storageItem.getName(), newQty);

    }

    @Override
    public void outcome(StorageItemDto storageItem) {
        double oldQty = storage.containsKey(storageItem.getName())
                ? storage.get(storageItem.getName())
                : 0;
        storage.put(storageItem.getName(), oldQty - storageItem.getQty());
    }

    @Override
    public void setRemainder(StorageItemDto storageItem) {
        storage.put(storageItem.getName(), storageItem.getQty());
    }

    @Override
    public StorageItemDto getRemainder(String storageItemName) {
        return storage.containsKey(storageItemName)
                ? new StorageItemDto(storageItemName, storage.get(storageItemName))
                : null;
    }

    @Override
    public List<StorageItemDto> getRemainders() {
        List<StorageItemDto> storageItemList = new ArrayList<>();

        for (Map.Entry<String,Double> entry : storage.entrySet()) {
            storageItemList.add(new StorageItemDto(entry.getKey(), entry.getValue()));
        }

        return storageItemList;
    }
}
