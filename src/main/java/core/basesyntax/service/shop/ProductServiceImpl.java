package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private final Storage storage;

    public ProductServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void fillProducts(List<FruitTransaction> transactions) {
        Map<String, Integer> fruits = new HashMap<>();
        transactions.stream()
                .map(FruitTransaction::getFruitName)
                .distinct()
                .forEach(fruit -> fruits.put(fruit, 0));
        storage.setFruits(fruits);
    }
}
