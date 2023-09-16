package core.basesyntax.report;

import java.io.IOException;
import java.util.Map;

public interface ReportCreator {
    void createReport(Map<String, Integer> fruitInventory, String filePath) throws IOException;
}
