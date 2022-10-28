package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.db.Store;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationImpl;
import core.basesyntax.strategy.operation.ReturnOperationImpl;
import core.basesyntax.strategy.operation.SupplyOperationImpl;
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
        Map<String, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(Operation.BALANCE.getOperation(),
                new BalanceOperationImpl());
        operationServiceMap.put(Operation.SUPPLY.getOperation(),
                new SupplyOperationImpl());
        operationServiceMap.put(Operation.PURCHASE.getOperation(),
                new PurchaseOperationImpl());
        operationServiceMap.put(Operation.RETURN.getOperation(),
                new ReturnOperationImpl());
        ReaderService readerService;
        String readData;
        try {
            readerService = new FileReaderServiceImpl(new BufferedReader(new FileReader(fromFile))
            );
            readData = readerService.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File don't found");
        }
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationServiceMap);
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
