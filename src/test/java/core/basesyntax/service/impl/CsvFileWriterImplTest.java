package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.AdditionalStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterImplTest {
    public static FileWriter csvFileWriter;
    public static FruitService fruitService;
    public static List<TransactionDto> transactionDtos;
    public static Map<Operation, OperationStrategy> operationStrategyMap;

    @BeforeClass
    public static void beforeClass() {
        csvFileWriter = new CsvFileWriterImpl();
        fruitService = new FruitServiceImpl(operationStrategyMap);
        transactionDtos = new ArrayList<>();
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionalStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionalStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionalStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());
        transactionDtos.add(new TransactionDto(Operation.BALANCE,
                new Fruit("banana"), 20));
        transactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 10));
        Storage.fruits.removeAll(Storage.fruits);
    }

    @Test(expected = RuntimeException.class)
    public void fileNotFound_Ok() {
        csvFileWriter
                .writeDataInFile(new HashMap<>(), "");
    }

    @Test
    public void dataWrite_Ok() {
        fruitService.applyAllOperators(transactionDtos);
        Map<String, Long> longMap = fruitService.getReport();
        csvFileWriter.writeDataInFile(longMap, "src/test/resources/checkWriteMethod.csv");
        try {
            List<String> lines = Files.readAllLines(Path.of("src/test/"
                    + "resources/checkWriteMethod.csv"));
            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line);
            }
            assertEquals("fruit,quantitybanana,10", sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file ");
        }
    }
}
