package core.basesyntax.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserCsvFile;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class TestWriter {
    private static final String PATH_FILE =
            "src/test/java/core/basesyntax/tests/resourcestests/fruitReport.csv";
    private final Map<Operation, OperationStrategy> operationOperationStrategyMap = new HashMap<>();
    private final List<String> lines = new ArrayList<>();
    private final FruitFileWriter writer = new CsvFileWriter();
    private Parser parser = new ParserCsvFile();
    private List<TransactionDto> transactions = new ArrayList<>();
    private FruitService service;

    @Before
    public void putDataInData() {
        operationOperationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationOperationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        operationOperationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationOperationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        lines.add("type,fruit,quantity");
        lines.add("b,banana,20");
        lines.add("b,apple,100");
        transactions = parser.parseCsvFile(lines);
        service = new FruitServiceImpl(operationOperationStrategyMap);
        service.applyOperation(transactions);
    }

    @Test
    public void createReport_OK() {
        Map<Fruit, Integer> data = Map.of(new Fruit("banana"),
                20, new Fruit("apple"), 100);
        writer.writeToFile(data, PATH_FILE);
        List<String> expected = List.of("fruit,quantity", "banana,20", "apple,100");
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(PATH_FILE));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + PATH_FILE);
        }
        assertEquals(expected, dataFromFile, "Lines from file must be equal");
    }
}
