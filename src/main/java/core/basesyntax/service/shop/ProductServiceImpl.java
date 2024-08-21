package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public void fillProducts(List<FruitTransaction> transactions) {
        transactions.stream()
                .map(FruitTransaction::getFruitName)
                .distinct()
                .forEach(fruitName-> Storage.fruits.put(fruitName,0));
    }
}
