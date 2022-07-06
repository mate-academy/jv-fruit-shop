package core.service.impl;

import core.service.ReportCreatorService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    @Override
    public String createReport(Map<String, Integer> leftovers) {
        String summary = leftovers.entrySet().stream()
                .map(k -> String.format("%s,%d", k.getKey(), k.getValue()))
                .collect(Collectors.joining("\n"));
        return "fruit,quantity\n" + summary;
    }
}
