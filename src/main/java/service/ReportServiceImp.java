package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import validator.Validator;
import validator.ValidatorImp;

public class ReportServiceImp implements ReportService {
    private static final String SEPARATOR = ",";
    private final Validator validator = new ValidatorImp();
    private final StrategyHandler strategyHandler;

    public ReportServiceImp(StrategyHandler strategyHandler) {
        this.strategyHandler = strategyHandler;
    }

    @Override
    public List<String> makeBalanceReport(List<String> activitiesList) {
        int sum;
        List<String> result = new ArrayList<>();
        result.add("fruit,quantity");

        Map<String, List<String[]>> stringListMap = activitiesList.stream()
                .map(line -> line.split(SEPARATOR))
                .filter(validator::validationReportLine)
                .collect(Collectors.groupingBy(strings -> strings[1]));

        for (String fruit:
                stringListMap.keySet()) {
            sum = 0;
            for (String[] activity:
                    stringListMap.get(fruit)) {
                sum += strategyHandler.get(activity[0]).apply(Integer.parseInt(activity[2]));
            }
            result.add(fruit + "," + sum);
        }
        return result;
    }
}
