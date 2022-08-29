package core.basesyntax.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import core.basesyntax.service.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {

    @Override
    public List<String> generate(Map<String, Integer> stringIntegerMap) {
        List<String> strings = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            strings.add(entry.getKey() + "," + entry.getValue());
        }
        return strings;
    }
}
