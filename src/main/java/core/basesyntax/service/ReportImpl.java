package core.basesyntax.service;

import core.basesyntax.Main;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class ReportImpl implements Report {
    private final Validator validator = new ValidatorImpl();
    private final OperationStrategy handlersStorage = new OperationStrategy();

    @Override
    public String report(List<String> list) {
        list.remove(0);
        validator.validate(list);
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity\n");

        for (String record : list) {
            String[] words = record.trim().split(",");
            String operationName = words[0];
            String fruitName = words[1];
            int fruitQuantity = Integer.parseInt(words[2]);
            OperationHandler operationHandler = handlersStorage.getHandlers().get(operationName);
            operationHandler.process(fruitName,fruitQuantity);
        }

        for (Map.Entry<String,Integer> pair: Main.fruitMap.entrySet()) {
            reportBuilder.append(pair.getKey())
                    .append(",")
                    .append(pair.getValue())
                    .append("\n");
        }
        return reportBuilder.toString();
    }
}
