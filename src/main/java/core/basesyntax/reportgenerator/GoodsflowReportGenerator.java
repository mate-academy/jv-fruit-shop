package core.basesyntax.reportgenerator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GoodsflowReportGenerator implements ReportGenerator {
    public static final String HEADER = "fruit, quantity";

    @Override
    public List<String> generateReport(List<String[]> parsedData) {
        List<String> retList = new LinkedList<>();
        Map<String, Integer> tmpMap = new HashMap<>();
        for (String[] row : parsedData) {
            if (tmpMap.containsKey(row[0])) {
                tmpMap.put(row[0], Integer.parseInt(row[1]) + tmpMap.get(row[0]));
                continue;
            }
            tmpMap.put(row[0], Integer.parseInt(row[1]));
        }
        retList.add(HEADER);
        retList.addAll(tmpMap.entrySet().stream()
                .map(en -> en.getKey() + "," + en.getValue())
                .toList());
        return retList;
    }
}
