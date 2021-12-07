package core.basesyntax.service;

import core.basesyntax.FruitShop;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class ReportBuilderImpl implements ReportBuilder {
    private final Validator validator = new ValidatorImpl();
    private final HandlersStorage handlersStorage = new HandlersStorage();

    @Override
    public String buildReport(List<String> list) {
        list.remove(0);// deleting heading
        validator.validate(list);
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");

        for (String record : list) {
            String[] words = record.trim().split(",");
            String operationName = words[0];
            String fruitName = words[1];
            int fruitQuantity = Integer.parseInt(words[2]);
            OperationHandler operationHandler = handlersStorage.getHandlers().get(operationName);
            operationHandler.process(fruitName,fruitQuantity);
        }

        for (Map.Entry<String,Integer> pair: FruitShop.fruitWarehouse.entrySet()) {
            report.append(pair.getKey())
                    .append(",")
                    .append(pair.getValue())
                    .append("\n");
        }
        return report.toString();
    }
}
