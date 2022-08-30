package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEAD_REPORT = "fruit,quantity";

    @Override
    public String create(Map<Fruit, Integer> storage) {
        List<String> reportList = new ArrayList<>();
        reportList.add(HEAD_REPORT);
        for(Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            reportList.add(entry.getKey().getName() + "," + entry.getValue());
        }
        return reportList.stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
