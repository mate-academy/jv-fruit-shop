package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImp implements ReportService {
    private static final String MINUS_ACTIVITIES_CODES = "p";

    @Override
    public List<String> makeBalanceReport(List<String> activitiesList) {
        int sum;
        List<String> result = new ArrayList<>();
        result.add("fruit,quantity");

        Map<String, List<String[]>> stringListMap = activitiesList.stream()
                .map(line -> line.split(","))
                .collect(Collectors.groupingBy(strings -> strings[1]));

        for (String fruit:
                stringListMap.keySet()) {
            sum = 0;
            for (String[] activity:
                    stringListMap.get(fruit)) {
                sum += checkType(activity);
            }
            result.add(fruit + "," + sum);
        }
        return result;
    }

    private int checkType(String[] activity) {
        int quantity = Integer.parseInt(activity[2]);
        return activity[0].equals(MINUS_ACTIVITIES_CODES) ? - quantity : quantity;
    }
}
