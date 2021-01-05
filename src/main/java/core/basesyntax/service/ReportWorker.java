package core.basesyntax.service;

import core.basesyntax.db.DataBase;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class ReportWorker implements ReportCheck {

    @Override
    public void readFromReport(String report,
                               Map<Procedure, OperationStrategy> operationStrategyMap) {
        final int operation = 0;
        final int typeFruit = 1;
        final int amount = 2;
        String[] file = report.split(" ");
        for (String line : file) {
            String[] temp = line.split(",");
            if (temp[operation].equals("type")) {
                continue;
            }
            if (operationStrategyMap.containsKey(Procedure
                    .findByProcedure(temp[operation]))) {
                operationStrategyMap.get(Procedure.findByProcedure(temp[operation]))
                        .apply(new Fruit(temp[typeFruit]),
                                Integer.parseInt(temp[amount]));
            }
        }
    }

    @Override
    public String writeToReport() {
        String topPattern = "fruit,quantity";
        StringBuilder report = new StringBuilder();
        report.append(topPattern).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruit
                : DataBase.getListItems().entrySet()) {
            report.append(fruit.getKey()).append(",")
                    .append(fruit.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
