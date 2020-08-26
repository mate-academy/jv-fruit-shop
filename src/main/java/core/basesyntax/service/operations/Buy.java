package core.basesyntax.service.operations;

import core.basesyntax.model.Product;
import java.util.List;
import java.util.stream.IntStream;

public class Buy implements Operation {
    @Override
    public boolean updateStorage(List<Product> products) {
        long countInStock = Operation.controllerDao.getAll().stream()
                .filter(p -> p.getFruitType().equalsIgnoreCase(products.get(0).getFruitType())
                && p.getExDate().isAfter(products.get(0).getExDate()))
                .count();
        if (countInStock - products.size() < 0) {
            return false;
        } else {
            IntStream.range(0, products.size())
                    .forEach(Operation.controllerDao::get);
            return true;
        }
    }
}
