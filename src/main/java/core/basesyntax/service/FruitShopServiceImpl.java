package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.strategy.OperationsStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private ProductDao productDao;
    private OperationsStrategy operationsStrategy;
    private ReaderService readerService;
    private WriterService writerService;

    public FruitShopServiceImpl(ProductDao productDao, OperationsStrategy operationsStrategy,
                                ReaderService readerService, WriterService writerService) {
        this.productDao = productDao;
        this.operationsStrategy = operationsStrategy;
        this.readerService = readerService;
        this.writerService = writerService;
    }

    @Override
    public void createReport(String filePathFrom, String filePathTo) {
        List<String> data = readerService.readFromFile(filePathFrom);

        ProductsService productsService = new ProductsServiceImpl(operationsStrategy, productDao);
        productsService.addToStorage(data);
        List<String> report = productsService.getFromStorage();

        writerService.writeToFile(report, filePathTo);
    }
}
