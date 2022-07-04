package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShiftReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShiftReportServiceImpl implements ShiftReportService {
    private int counter;

    @Override
    public List<String> reportMaker(Map<Fruit, Integer> shiftReport) {
        List<String> reportList = new ArrayList<>();
        reportList.add("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry: shiftReport.entrySet()) {
            reportList.add(entry.getKey().getFruit() + "," + entry.getValue());
            counter++;
            if (counter != reportList.size()) {
                reportList.add(System.lineSeparator());
            }
        }
        return reportList;
    }
}
