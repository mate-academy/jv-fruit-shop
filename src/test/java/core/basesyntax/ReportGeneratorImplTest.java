package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class ReportGeneratorImplTest {
    private final ReportGenerator reportGenerator = new ReportGeneratorImpl();

    @Test
    void emptyMap_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            reportGenerator.getReport(Collections.emptyMap());
        });
    }

}
