package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BalanceReportImpl implements ReportCreator {
    @Override
    public List<String[]> createReport(Map<String, Integer> data) {
        List<String[]> fruitsList = new ArrayList<>();
        fruitsList.add(new String[]{"fruit", "quantity"});
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            fruitsList.add(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
        }
        return fruitsList;
    }
}
