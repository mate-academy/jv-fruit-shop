package core.basesyntax.strategy;

import java.util.Map;

public interface ReportService {

    String SPLITTER = ",";
    void apply(Map<String, Integer> map, String data);
}
