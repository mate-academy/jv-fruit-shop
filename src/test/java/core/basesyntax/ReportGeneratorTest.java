package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportGeneratorTest {

    private FruitDB fruitDB;
    private ReportGenerator reportGenerator;

    @BeforeEach
    void setUp() {
        fruitDB = new FruitDB();
        reportGenerator = new ReportGenerator(fruitDB);
    }

    @Test
    void testGenerate() {
        fruitDB.add("banana", 130);
        fruitDB.add("apple", 200);

        List<String> report = reportGenerator.generate();

        assertEquals(2, report.size());
        assertEquals("banana,130", report.get(0));
        assertEquals("apple,200", report.get(1));
    }
}
