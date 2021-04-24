package core.basesyntax.service;

import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private ReaderService readerService;
    private WriterService writerService;
    private ProductsService productsService;

    public FruitShopServiceImpl(ProductsService productsService,
                                ReaderService readerService, WriterService writerService) {
        this.productsService = productsService;
        this.readerService = readerService;
        this.writerService = writerService;
    }

    @Override
    public void createReport(String filePathFrom, String filePathTo) {
        List<String> data = readerService.readFromFile(filePathFrom);

        productsService.addToStorage(data);
        List<String> report = productsService.getFromStorage();

        writerService.writeToFile(report, filePathTo);
    }
}
