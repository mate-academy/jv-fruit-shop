package core.basesyntax.service.shop;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final Storage storage;

    public ProductServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void fillProducts(List<FruitTransaction> transactions) {
        storage.setProducts(transactions.stream()
                .map(FruitTransaction::getFruitName)
                .distinct()
                .map(Fruit::new)
                .toList());
    }

    @Override
    public Fruit getProductByName(String nameOfProduct) {
        return storage.getProducts().stream()
                .filter(product -> product.getFruitName().equals(nameOfProduct))
                .findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
