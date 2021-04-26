package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.parser.FileEntryParser;
import core.basesyntax.service.parser.FileEntryParserImpl;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final FileEntryReader reader;
    private final OperationStrategy handlers;
    private final ProductDao productDao;
    private final FileEntryWriter writer;

    public FruitShopServiceImpl(FileEntryReader reader,
                                OperationStrategy operationStrategy,
                                ProductDao productDao,
                                FileEntryWriter writer) {
        this.reader = reader;
        this.handlers = operationStrategy;
        this.productDao = productDao;
        this.writer = writer;
    }

    @Override
    public void createReport(String pathFrom, String pathTo) {
        FileEntryParser parser = new FileEntryParserImpl();
        List<String> records = reader.readFile(pathFrom);
        List<Transaction> productFactories = parser.parseProduct(records);
        for (Transaction product : productFactories) {
            OperationHandler handler = handlers.get(product.getOperation());
            int amount = handler.apply(product.getAmount(), product.getFruit());
            productDao.add(product.getFruit(), amount);
        }
        writer.writeToFile(pathTo);
    }
}
