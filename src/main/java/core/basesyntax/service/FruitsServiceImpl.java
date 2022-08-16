package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.csvfileservice.ReaderService;
import core.basesyntax.service.csvfileservice.WriterService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class FruitsServiceImpl implements FruitsService {
    private FruitsDao fruitsDao;
    private OperationStrategy operationStrategy;
    private ReaderService readerService;
    private WriterService writerService;

    public FruitsServiceImpl(FruitsDao fruitsDao,
                             OperationStrategy operationStrategy,
                             ReaderService readerService,
                             WriterService writerService) {
        this.fruitsDao = fruitsDao;
        this.operationStrategy = operationStrategy;
        this.readerService = readerService;
        this.writerService = writerService;
    }

    @Override
    public void generateFruitsReport() {
        makeFruitsDailyUpdate();
        Map<String, Integer> fruits = fruitsDao.getStorageData();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruits.entrySet()) {
            stringBuilder.append(fruit.getKey()).append(",").append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        writerService.writeDataToCsv(stringBuilder.toString());
    }

    private void makeFruitsDailyUpdate() {
        readerService.getFruitTransactionsFromCsv()
                .forEach(f -> operationStrategy.getOperation(f.getOperation())
                        .updateFruitsQuantity(f));
    }
}
