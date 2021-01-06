package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitServiceImplTest {
    static FruitService fruitService;
    static List<Record> records;

    @BeforeAll
    static void beforeAll() {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        records = new ArrayList<>();

        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        fruitService = new FruitServiceImpl(operationStrategyMap);

        Record firstRecord = new Record(Operation.BALANCE, new Fruit("banana"), 98L);
        Record secondRecord = new Record(Operation.BALANCE, new Fruit("cherry"), 56L);
        Record thirdRecord = new Record(Operation.SUPPLY, new Fruit("cherry"), 150L);
        Record fourthRecord = new Record(Operation.PURCHASE, new Fruit("banana"), 3L);
        Record fifthRecord = new Record(Operation.RETURN, new Fruit("banana"), 3L);

        records.add(firstRecord);
        records.add(secondRecord);
        records.add(thirdRecord);
        records.add(fourthRecord);
        records.add(fifthRecord);
    }

    @BeforeEach
    void setUp() {
        Storage.getStorage().clear();
    }

    @Test
    void applyOperations_Ok() {
        long bananaExpected = 98L;
        long cherryExpected = 206L;

        fruitService.applyOperationOnRecord(records);
        long bananaActual = Storage.getStorage().get(new Fruit("banana"));
        long cherryActual = Storage.getStorage().get(new Fruit("cherry"));

        assertEquals(bananaExpected, bananaActual);
        assertEquals(cherryExpected, cherryActual);
    }

    @Test
    void getFruitReport_Ok() {
        long bananaExpected = 98L;
        long cherryExpected = 206L;

        fruitService.applyOperationOnRecord(records);
        Map<String, Long> report = fruitService.getFruitReport();
        long bananaActual = report.get("banana");
        long cherryActual = report.get("cherry");

        assertEquals(bananaExpected, bananaActual);
        assertEquals(cherryExpected, cherryActual);
    }
}
