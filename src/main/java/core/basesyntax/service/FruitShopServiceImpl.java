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
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromFile(filePathFrom);

        ProductService productService = new ProductServiceImpl(operationsStrategy, productDao);
        productService.addToStorage(data);
        List<String> report = productService.getFromStorage();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, filePathTo);
    }
}
