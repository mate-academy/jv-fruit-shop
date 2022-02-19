package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import validator.Validator;

public class ReporterImpl implements Reporter {
    private Validator validator;
    private OperationStrategy operationStrategy;

    public ReporterImpl(Validator validator, OperationStrategy operationStrategy) {
        this.validator = validator;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> report(List<String> data) {
        validator.validate(data);
        Map<String, Integer> fruitBalance = new HashMap<>();
        for (String element : data) {
            String[] split = element.split(",");
            if (split[0].equals("b")) {
                fruitBalance.put(split[1], 0);
            }
        }
        for (String element : data) {
            String[] split = element.split(",");
            fruitBalance.replace(split[1], fruitBalance.get(split[1])
                    + operationStrategy.get(split[0])
                    .getOperation(Integer.parseInt(split[2])));
        }
        return fruitBalance;
    }
}
