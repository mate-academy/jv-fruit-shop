package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileService;
import service.Strategy;
import service.Validator;
import service.ValueReport;

public class ValueReportImpl implements ValueReport {
    private static final int FIRST_VALUE_LINE = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_LINE_INDEX = 1;
    private static final int FRUIT_COUNT_LINE_INDEX = 2;
    private static final String REPORT_CAPTION = "fruit,quantity";
    private static final String REPORT_SEPARATOR = ",";
    private final FileService fileService;
    private final Strategy strategy;
    private final Validator validator;

    public ValueReportImpl(FileService fileDao, Strategy strategy, Validator validation) {
        this.fileService = fileDao;
        this.strategy = strategy;
        this.validator = validation;
    }

    public void fillReportMap(List<String> inputValues, Map<String, Integer> report) {
        validator.validateInformation(inputValues);
        for (int i = FIRST_VALUE_LINE; i < inputValues.size(); i++) {
            String[] inputArray = inputValues.get(i).split(REPORT_SEPARATOR);
            int countFruit = strategy
                    .getActivity(inputArray[OPERATION_INDEX])
                    .getFruitAmount(Integer.parseInt(inputArray[FRUIT_COUNT_LINE_INDEX]));
            report.merge(inputArray[FRUIT_TYPE_LINE_INDEX], countFruit, Integer::sum);
        }
    }

    private String mapToString(Map<String, Integer> report) {
        StringBuilder stringForReport = new StringBuilder()
                .append(REPORT_CAPTION)
                .append(System.lineSeparator());

        for (Map.Entry<String, Integer> mapValue : report.entrySet()) {
            stringForReport.append(mapValue.getKey())
                    .append(REPORT_SEPARATOR)
                    .append(mapValue.getValue())
                    .append(System.lineSeparator());
        }
        return stringForReport.toString();
    }

    @Override
    public void getReport(String inputFilePath, String reportFilePath) {
        Map<String, Integer> report = new HashMap<>();
        List<String> inputValues = fileService.readFromFile(inputFilePath);
        fillReportMap(inputValues, report);
        fileService.writeToReportFile(mapToString(report), reportFilePath);
    }
}
