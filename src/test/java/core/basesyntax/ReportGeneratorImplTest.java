package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import result.ReportGenerator;
import result.ReportGeneratorImpl;

class ReportGeneratorImplTest {
    private ReportGenerator reportGenerator;

    @BeforeEach
    void setUp() {
        reportGenerator = new ReportGeneratorImpl();
    }

    @Test
    void generateValidReport() {
        Map<String, Integer> storage = new HashMap<>();
        storage.put("banana", 150);
        storage.put("apple", 200);

        String report = reportGenerator.generateReport(storage);
        String expected = "fruit,quantity\n"
                + "apple,200\n"
                + "banana,150\n";
        assertEquals(expected, report);
    }

    @Test
    void generateEmptyReport() {
        Map<String, Integer> storage = new HashMap<>();
        String report = reportGenerator.generateReport(storage);
        assertEquals("fruit,quantity\n", report);
    }
}
