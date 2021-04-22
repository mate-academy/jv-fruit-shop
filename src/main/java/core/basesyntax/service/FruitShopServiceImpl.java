package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.strategy.OperationsStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private ProductDao productDao;
    private OperationsStrategy operationsStrategy;

    public FruitShopServiceImpl(ProductDao productDao, OperationsStrategy operationsStrategy) {
        this.productDao = productDao;
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public void createReport(String filePathFrom, String filePathTo) {
        ReaderService readerService = new CsvReaderServiceImpl();
        List<String> data = readerService.readFromFile(filePathFrom);

        ProductsService productsService = new ProductsServiceImpl(operationsStrategy, productDao);
        productsService.addToStorage(data);
        List<String> report = productsService.getFromStorage();

        WriterService writerService = new CsvWriterServiceImpl();
        writerService.writeToFile(report, filePathTo);
    }
}
