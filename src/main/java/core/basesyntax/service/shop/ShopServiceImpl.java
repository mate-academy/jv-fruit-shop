package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final ProductService productService;

    public ShopServiceImpl(OperationStrategy operationStrategy, ProductService productService) {
        this.operationStrategy = operationStrategy;
        this.productService = productService;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        productService.fillProducts(transactions);
        transactions.forEach(transaction -> operationStrategy
                .getOperationHandlers(transaction.getOperation())
                .transaction(transaction, productService.getProductByName(transaction.getFruitName())));
    }
}
