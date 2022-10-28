package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.BalanceOperationStrategyImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationStrategyImpl;
import core.basesyntax.service.impl.ReturnOperationStrategyImpl;
import core.basesyntax.service.impl.SupplyOperationStrategyImpl;
import core.basesyntax.storage.Store;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String fromFile = "src/main/resources/input.csv";
    private static final String toFile = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, OperationStrategyImpl> operationServiceMap = new HashMap<>();
        operationServiceMap.put(Operation.BALANCE.getOperation(),
                new BalanceOperationStrategyImpl());
        operationServiceMap.put(Operation.SUPPLY.getOperation(),
                new SupplyOperationStrategyImpl());
        operationServiceMap.put(Operation.PURCHASE.getOperation(),
                new PurchaseOperationStrategyImpl());
        operationServiceMap.put(Operation.RETURN.getOperation(),
                new ReturnOperationStrategyImpl());
        ReaderService readerService;
        String readData;
        try {
            readerService = new FileReaderServiceImpl(new BufferedReader(new FileReader(fromFile))
            );
            readData = readerService.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File don't found");
        }
        OperationStrategy operationStrategy = new OperationStrategy(operationServiceMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.getReport(readData);
        WriterService writerService;
        try {
            writerService = new FileWriterServiceImpl(new BufferedWriter(
                    new FileWriter(toFile))
            );
            writerService.write(Store.FRUIT_STORAGE);
        } catch (IOException e) {
            throw new RuntimeException("Cannot create file");
        }
    }
}
