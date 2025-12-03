package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriteService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportWriteServiceImpl implements ReportWriteService {
    @Override
    public List<String> writeReport(Map<String, Integer> report) {
        List<String> output = new ArrayList<>();
        output.add("fruit, quantity");

        report.forEach((fruit, quantity) -> output.add(fruit + "," + quantity));
        return output;
    }
}
