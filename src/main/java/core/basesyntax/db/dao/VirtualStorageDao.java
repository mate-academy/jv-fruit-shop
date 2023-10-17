package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.db.VirtualStorage;
import core.basesyntax.db.dto.StorageItemDto;
import java.util.ArrayList;
import java.util.List;

public class VirtualStorageDao implements StorageDao {
    private final Storage storage = new VirtualStorage();

    @Override
    public void clearStorage() {
        storage.clear();
    }

    @Override
    public StorageItemDto income(StorageItemDto storageItem) {
        storage.stock(storageItem);
        return storage.getRemainder(storageItem.getName());
    }

    @Override
    public List<StorageItemDto> income(List<StorageItemDto> storageItemList) {
        List<StorageItemDto> newRemainders = new ArrayList<>();

        for (StorageItemDto storageItem : storageItemList) {
            newRemainders.add(income(storageItem));
        }

        return newRemainders;
    }

    @Override
    public StorageItemDto outcome(StorageItemDto storageItem) {
        storage.withdraw(storageItem);
        return storage.getRemainder(storageItem.getName());
    }

    @Override
    public List<StorageItemDto> outcome(List<StorageItemDto> storageItemList) {
        List<StorageItemDto> newRemainders = new ArrayList<>();

        for (StorageItemDto storageItem : storageItemList) {
            newRemainders.add(outcome(storageItem));
        }

        return newRemainders;
    }

    @Override
    public StorageItemDto setRemainder(StorageItemDto storageItem) {
        storage.setRemainder(storageItem);
        return storage.getRemainder(storageItem.getName());
    }

    @Override
    public List<StorageItemDto> setRemainder(List<StorageItemDto> storageItemList) {
        List<StorageItemDto> newRemainders = new ArrayList<>();

        for (StorageItemDto storageItem : storageItemList) {
            newRemainders.add(setRemainder(storageItem));
        }

        return newRemainders;
    }

    @Override
    public StorageItemDto getRemainder(String storageItemName) {
        return storage.getRemainder(storageItemName);
    }

    @Override
    public List<StorageItemDto> getRemainders() {
        return storage.getRemainders();
    }
}
