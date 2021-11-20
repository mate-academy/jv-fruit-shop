package core.basesyntax.service;

import java.util.List;
import java.util.stream.Collectors;

public class DataFormatter {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String SEPARATOR = ",";
    private final ReportValidator validator;

    public DataFormatter(ReportValidator reportValidator) {
        this.validator = reportValidator;
    }

    public String formatReport(List<String> data){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRUIT)
                .append(SEPARATOR)
                .append(QUANTITY)
                .append(System.lineSeparator());
        data.forEach(l -> stringBuilder.append(l).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }

    public List<String> formatInputData(List<String> data){
        return data.stream()
                .filter(validator)
                .collect(Collectors.toList());
    }
}
