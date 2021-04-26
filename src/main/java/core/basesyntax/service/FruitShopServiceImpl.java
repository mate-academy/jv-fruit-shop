package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.Product;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String COMMA = ",";
    private final OperationStrategy handlers;
    private final ProductDao productDao;

    public FruitShopServiceImpl(OperationStrategy operationStrategy,
                                ProductDao productDao) {
        this.handlers = operationStrategy;
        this.productDao = productDao;
    }

    @Override
    public void saveData(List<TransactionDto> data) {
        for (TransactionDto product : data) {
            OperationHandler handler = handlers.get(product.getOperation());
            int amount = handler.apply(product.getAmount(), product.getFruit());
            productDao.add(product.getFruit(), amount);
        }
    }

    @Override
    public String createReport() {
        StringBuilder buildReport = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : productDao.getAll().entrySet()) {
            buildReport.append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return buildReport.toString();
    }
}
