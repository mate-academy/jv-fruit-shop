package core.basesyntax;

import java.util.*;

public interface ReportGenerator {
    public List<String> getReport(Map<String, Integer> storage);
}
