package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> getReport(Map<String, Integer> storage) {
        List<String> raport = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            raport.add(entry.getKey() + "," + entry.getValue());
        }
        return raport;
    }
}
