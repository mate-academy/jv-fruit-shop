package core.basesyntax.service;

import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private ReaderService readerService;
    private WriterService writerService;
    private WarehouseService warehouseService;

    public FruitShopServiceImpl(WarehouseService warehouseService,
                                ReaderService readerService, WriterService writerService) {
        this.warehouseService = warehouseService;
        this.readerService = readerService;
        this.writerService = writerService;
    }

    @Override
    public void createReport(String filePathFrom, String filePathTo) {
        List<String> data = readerService.readFromFile(filePathFrom);

        warehouseService.addToStorage(data);
        List<String> report = warehouseService.getFromStorage();

        writerService.writeToFile(report, filePathTo);
    }
}
