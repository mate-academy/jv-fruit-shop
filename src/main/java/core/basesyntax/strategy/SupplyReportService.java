package core.basesyntax.strategy;

import java.util.Map;

public class SupplyReportService implements ReportService {
    @Override
    public void apply(Map<String, Integer> map, String data) {
        String key = data.split(SPLITTER, 2)[0];
        Integer value = Integer.parseInt(data.split(SPLITTER, 2)[1]) + map.get(key);
        map.put(key, value);
    }
}
