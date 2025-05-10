package core.basesyntax.db.impl;

import core.basesyntax.db.BalanceStorageDao;
import core.basesyntax.dto.BalanceDto;
import core.basesyntax.model.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBalanceStorageDao implements BalanceStorageDao {
    private static BalanceStorageDao instance;

    private final Map<Product, Integer> storage;

    private InMemoryBalanceStorageDao() {
        this.storage = new HashMap<>();
    }

    public static BalanceStorageDao getInstance() {
        if (instance == null) {
            instance = new InMemoryBalanceStorageDao();
        }
        return instance;
    }

    public void save(Product product, int quantity) {
        storage.put(product, quantity);
    }

    public int getQuantity(Product product) {
        return storage.getOrDefault(product, 0);
    }

    public List<BalanceDto> getAll() {
        return storage.entrySet().stream()
                .map(this::mapToDto)
                .toList();
    }

    public int remove(Product product) {
        return storage.remove(product);
    }

    public void clear() {
        storage.clear();
    }

    private BalanceDto mapToDto(Map.Entry<Product, Integer> item) {
        return new BalanceDto(item.getKey(), item.getValue());
    }
}
