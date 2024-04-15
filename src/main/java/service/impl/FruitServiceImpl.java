package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FileWriterService;
import service.FruitService;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private static final String STORAGE_PATH = "src/main/java/db/storage.csv";
    private static final FileWriterService fileWriter = new FileWriterServiceImpl();
    private static final int PRIMARY_QUANTITY = 0;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> dataFromCsv) {

        String collect = dataFromCsv.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summingInt(line -> operationStrategy.get(line.getOperation())
                                .executionOfOperation(line.getQuantity(), PRIMARY_QUANTITY))))
                .toString();

        fileWriter.writeToFile(collect, STORAGE_PATH);

    }
}
