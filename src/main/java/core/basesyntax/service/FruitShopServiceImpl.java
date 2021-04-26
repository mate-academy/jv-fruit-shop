package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.ProductFactory;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final CsvReader reader;
    private final OperationStrategy handlers;
    private final ProductDao productDao;
    private final CsvWriter writer;

    public FruitShopServiceImpl(CsvReader reader,
                                OperationStrategy operationStrategy,
                                ProductDao productDao,
                                CsvWriter writer) {
        this.reader = reader;
        this.handlers = operationStrategy;
        this.productDao = productDao;
        this.writer = writer;
    }

    @Override
    public void createReport(String pathFrom, String pathTo) {
        ProductParser parser = new ProductParserImpl();
        List<String> records = reader.readFile(pathFrom);
        List<ProductFactory> productFactories = parser.parseProduct(records);
        for (ProductFactory product : productFactories) {
            OperationHandler handler = handlers.get(product.getOperation());
            int amount = handler.apply(product.getAmount(), product.getFruit());
            productDao.add(product.getFruit(), amount);
        }
        writer.writeToFile(pathTo);
    }
}