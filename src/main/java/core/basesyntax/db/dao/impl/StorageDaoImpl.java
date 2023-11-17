package core.basesyntax.db.dao.impl;

import core.basesyntax.db.InMemoryStorage;
import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.model.Item;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void balance(Item item) {
        setQuantityByName(item.getName(), item.getQuantity());
    }

    @Override
    public void purchase(Item item) {
        Integer oldQuantity = getQuantityByNameItem(item.getName());
        Integer newQuantity = oldQuantity - item.getQuantity();
        setQuantityByName(item.getName(), newQuantity);
    }

    @Override
    public void returnItem(Item item) {
        Integer oldQuantity = getQuantityByNameItem(item.getName());
        Integer newQuantity = oldQuantity + item.getQuantity();
        setQuantityByName(item.getName(), newQuantity);
    }

    @Override
    public void supply(Item item) {
        Integer oldQuantity = getQuantityByNameItem(item.getName());
        Integer newQuantity = oldQuantity + item.getQuantity();
        setQuantityByName(item.getName(), newQuantity);
    }

    private Integer getQuantityByNameItem(String name) {
        return InMemoryStorage.items.getOrDefault(name, 0);
    }

    private void setQuantityByName(String name, Integer quantity) {
        InMemoryStorage.items.put(name, quantity);
    }
}
