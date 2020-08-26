package core.basesyntax.service.operations;

import core.basesyntax.model.Product;
import java.util.List;
import java.util.stream.IntStream;

public class Supply implements Operation {
    @Override
    public boolean updateStorage(List<Product> products) {
        return IntStream.range(0, products.size())
                .allMatch(i -> controllerDao.put(products.get(i)));
    }
}
