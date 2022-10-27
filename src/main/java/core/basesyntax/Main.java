package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.BalanceOperationServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationServiceImpl;
import core.basesyntax.service.impl.ReturnOperationServiceImpl;
import core.basesyntax.service.impl.SupplyOperationServiceImpl;
import core.basesyntax.storage.Store;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
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
        Store.FRUIT_STORAGE.put(Fruit.APPLE.getName(), null);
        Store.FRUIT_STORAGE.put(Fruit.BANANA.getName(), null);
        Map<String, OperationService> operationServiceMap = new HashMap<>();
        operationServiceMap.put(Operation.BALANCE.getOperation(),
                new BalanceOperationServiceImpl());
        operationServiceMap.put(Operation.SUPPLY.getOperation(),
                new SupplyOperationServiceImpl());
        operationServiceMap.put(Operation.PURCHASE.getOperation(),
                new PurchaseOperationServiceImpl());
        operationServiceMap.put(Operation.RETURN.getOperation(),
                new ReturnOperationServiceImpl());
        StringBuilder dataFromFile = readFromFile();
        OperationStrategy operationStrategy = new OperationStrategy(operationServiceMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.getReport(dataFromFile);
        writeDataToFile();
    }

    private static StringBuilder readFromFile() {
        ReaderService readerService;
        StringBuilder readData;
        try {
            readerService = new FileReaderServiceImpl(new BufferedReader(new FileReader(fromFile))
            );
            readData = readerService.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File don't found");
        }
        return readData;
    }

    private static void writeDataToFile() {
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
