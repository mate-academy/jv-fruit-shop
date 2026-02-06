package basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import basesyntax.service.impl.ReportGeneratorImpl;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportGeneratorImplTest {
    private ReportGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new ReportGeneratorImpl();
    }

    @Test
    void generate_validData_ok() {
        Map<String, Integer> data = Map.of("banana", 10);

        String report = generator.generate(data);

        assertTrue(report.contains("banana"));
        assertTrue(report.contains("10"));
    }
}
