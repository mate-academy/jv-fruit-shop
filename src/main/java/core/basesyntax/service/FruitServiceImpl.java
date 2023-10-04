package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private Map<String, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<String, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public String createReport(String data) {
        Map<String, Integer> groupedReport = getGroupedReport(data);
        String resultReport = "fruit,quantity" + System.lineSeparator()
                + getResultReport(groupedReport);
        return resultReport;
    }

    private Map<String, Integer> getGroupedReport(String data) {
        Map<String, Integer> resultReport = new HashMap<>();
        String[] reports = data.split(System.lineSeparator());
        for (int i = 1; i < reports.length; i++) {
            String[] report = reports[i].split(",");
            if (resultReport.containsKey(report[FRUIT_INDEX])) {
                Integer value = operationStrategyMap
                        .get(report[TYPE_INDEX])
                        .getAmount(report);
                resultReport.put(report[FRUIT_INDEX],
                        value + resultReport.get(report[FRUIT_INDEX]));
            } else {
                resultReport.put(report[FRUIT_INDEX], Integer.parseInt(report[AMOUNT_INDEX]));
            }
        }
        return resultReport;
    }

    private String getResultReport(Map<String, Integer> groupedReport) {
        return groupedReport.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining()).trim();
    }
}
