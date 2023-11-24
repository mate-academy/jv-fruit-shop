package core.basesyntax.servise;

import core.basesyntax.validators.ReportValidator;

import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static ReportValidator reportValidator;

    public ReportServiceImpl() {
        reportValidator = new ReportValidator();
    }

    @Override
    public String getReport(List<String> dataFromFile) {
        List<List<String>> sortedData = sortByFruits(dataFromFile);
        return processData(sortedData);
    }

    private List<List<String>> sortByFruits(List<String> dataFromFile) {
        return dataFromFile.stream()
                .skip(1)
                .collect(Collectors.groupingBy(string ->
                        string.split(COMMA)[FRUIT_INDEX]))
                .values()
                .stream()
                .toList();
    }

    private String processData(List<List<String>> list) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(HEADER)
                .append(System.lineSeparator());
        for (int i = 0; i < list.size(); i++) {
            int[] arr = new int[list.size()];
            for (String string : list.get(i)) {
                String action = string.split(COMMA)[ACTION_INDEX];
                int value = Integer.parseInt(string.split(COMMA)[AMOUNT_INDEX]);
                if (action.matches("[srb]")) {
                    arr[i] += value;
                } else if (action.equals("p")) {
                    arr[i] -= value;
                }
            }
            reportValidator.validate(arr[i]);
            stringBuilder.append(list.get(i).get(0).split(COMMA)[FRUIT_INDEX])
                    .append(COMMA)
                    .append(arr[i])
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
