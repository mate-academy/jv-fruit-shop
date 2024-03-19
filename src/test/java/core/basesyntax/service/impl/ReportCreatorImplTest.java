package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.ReportCreator;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportCreatorImplTest {
    private ReportCreator reportCreator;

    @BeforeEach
    void setUp() {
        reportCreator = new ReportCreatorImpl();
    }

    @Test
    void createReport_ok() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("banana", 20);
        map.put("apple", 50);

        String actual = reportCreator.createReport(map);
        String expected = """
                fruit,quantity
                apple,50
                banana,20
                """;
        assertEquals(expected, actual);
    }

    @Test
    void createReport_negativeQuantity_notOk() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("banana", -10);
        map.put("apple", 50);

        assertThrows(IllegalArgumentException.class, () ->
                reportCreator.createReport(map));
    }
}
