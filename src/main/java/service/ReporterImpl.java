package service;

import dao.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import validator.Validator;

public class ReporterImpl implements Reporter {
    private Validator validator;
    private Reader reader;
    private OperationStrategy operationStrategy;

    public ReporterImpl(Validator validator, Reader reader, OperationStrategy operationStrategy) {
        this.validator = validator;
        this.reader = reader;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> report() {
        List<String> data = reader.read();
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
