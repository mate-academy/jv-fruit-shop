package service.impl;

import java.util.List;
import java.util.Map;
import service.Strategy;
import service.TransactionData;
import service.Validator;

public class TransactionDataImpl implements TransactionData {
    private static final int FIRST_VALUE_LINE = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_LINE_INDEX = 1;
    private static final int FRUIT_COUNT_LINE_INDEX = 2;
    private static final String REPORT_SEPARATOR = ",";
    private final Validator validator;
    private final Strategy strategy;

    public TransactionDataImpl(Validator validator, Strategy strategy) {
        this.validator = validator;
        this.strategy = strategy;
    }

    @Override
    public Map<Fruit, Integer> parseDataToMap(List<String> data, Map<Fruit, Integer> report) {
        validator.validateInformation(data);
        for (int i = FIRST_VALUE_LINE; i < data.size(); i++) {
            String[] inputArray = data.get(i).split(REPORT_SEPARATOR);
            int countFruit = strategy
                    .getActivity(inputArray[OPERATION_INDEX])
                    .getFruitAmount(Integer.parseInt(inputArray[FRUIT_COUNT_LINE_INDEX]));
            report.merge(new Fruit(inputArray[FRUIT_TYPE_LINE_INDEX]), countFruit, Integer::sum);
        }
        return report;
    }
}
