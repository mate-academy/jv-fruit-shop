package core.fruitshop.services.impl;

import core.fruitshop.db.Storage;
import core.fruitshop.model.FruitTransaction;
import core.fruitshop.services.DataExtractor;
import core.fruitshop.services.FileWorker;
import core.fruitshop.services.FruitShopService;
import core.fruitshop.strategy.interfaces.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String COLUMN_SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String DATA_FILE_HEADER = "type,fruit,quantity";

    private final FileWorker fileWorker;
    private final DataExtractor dataExtractor;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(FileWorker fileWorker, DataExtractor dataExtractor,
                                OperationStrategy operationStrategy) {
        this.fileWorker = fileWorker;
        this.dataExtractor = dataExtractor;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(String fileName) {
        for (String line : fileWorker.readFromFile(fileName)) {
            if (line.contains(DATA_FILE_HEADER)) {
                continue;
            }
            FruitTransaction transaction = dataExtractor.parse(line);
            operationStrategy.getStrategy(transaction.getType())
                    .handle(transaction.getProductName(),
                    transaction.getAmount());
        }
        System.out.println("Successfully processed data from " + fileName);
    }

    @Override
    public void createReport(String fileName) {
        fileWorker.writeToFile(fileName, REPORT_HEADER, COLUMN_SEPARATOR, Storage.fruitsStorage);
        System.out.println("Successfully created report in " + fileName);
    }
}
