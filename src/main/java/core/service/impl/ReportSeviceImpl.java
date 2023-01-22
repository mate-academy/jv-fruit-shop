package core.service.impl;

import core.service.ReportSevice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportSeviceImpl implements ReportSevice {
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public List<String> reportGenerator(Map<String, Integer> fruits) {
        List<String> report = new ArrayList<>();
        report.add(FIRST_LINE);
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
