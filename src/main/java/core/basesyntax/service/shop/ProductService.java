package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProductService {
    void fillProducts(List<FruitTransaction> transactions);

}
