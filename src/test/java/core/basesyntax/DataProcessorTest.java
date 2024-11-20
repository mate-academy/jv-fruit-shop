package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataProcessorTest {

    private FruitDB fruitDB;
    private DataProcessor dataProcessor;

    @BeforeEach
    void setUp() {
        fruitDB = new FruitDB();
        dataProcessor = new DataProcessor(fruitDB, new DefaultDataOperationStrategy());
    }

    @Test
    void testProcess() {
        List<FruitTransaction> transactions = List.of(
                new FruitTransaction("b", "banana", 100),
                new FruitTransaction("s", "banana", 50),
                new FruitTransaction("p", "banana", 30),
                new FruitTransaction("r", "banana", 10)
        );
        dataProcessor.process(transactions);
        assertEquals(130, fruitDB.getInventory().get("banana"));
    }
}
