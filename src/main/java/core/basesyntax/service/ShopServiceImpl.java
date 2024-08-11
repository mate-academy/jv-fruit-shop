package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.OperationStrategy;
import core.basesyntax.model.Product;
import core.basesyntax.storage.Storage;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        fillProducts(transactions);
        transactions.forEach(transaction -> operationStrategy.getOperationHandlers()
                .get(transaction.getOperation()).transaction(transaction,
                        getProductByName(transaction.getNameOfProduct())));
    }

    private void fillProducts(List<FruitTransaction> transactions) {
        storage.setProducts(transactions.stream()
                .map(FruitTransaction::getNameOfProduct)
                .distinct()
                .map(Product::new)
                .toList());
    }

    private Product getProductByName(String nameOfProduct) {
        return storage.getProducts().stream()
                .filter(product -> product.getNameOfProduct().equals(nameOfProduct))
                .findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
