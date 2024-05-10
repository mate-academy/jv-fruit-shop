package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.ReportCreatorService;

public class BalanceReportCreatorService implements ReportCreatorService {
    private static final String REPORT_ANNOTATION = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public List<String> getReport(Map<String, Integer> statistic) {
        List<String> finalFile = new ArrayList<>();
        finalFile.add(REPORT_ANNOTATION);

        List<String> statisticToString = statistic.entrySet().stream()
                .peek(kv -> {
                    if (kv.getValue() < 0) {
                        throw new RuntimeException("Balance is negative");
                    }
                })
                .map(kv -> kv.getKey() + SEPARATOR + kv.getValue())
                .collect(Collectors.toList());
        finalFile.addAll(statisticToString);
        return finalFile;
    }
}
