package tests;

import core.basesyntax.ReportGenerator;
import core.basesyntax.ReportGeneratorImpl;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportGeneratorTest {
    @Test
    public void testReportGenerator() {
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        Map<String, Integer> storage = new HashMap<>();
        storage.put("banana", 152);
        storage.put("apple", 90);
        String expectedReport = "fruit,quantity\nbanana,152\napple,90\n";
        assertEquals(expectedReport, reportGenerator.getReport(storage));
    }
}
