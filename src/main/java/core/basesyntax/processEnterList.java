package core.basesyntax;

import java.util.List;

public class processEnterList {

    public processEnterList(OperationsStrategyImpl operationsStrategyImpl) {
        this.operationsStrategyImpl = operationsStrategyImpl;
    }

    private final OperationsStrategyImpl operationsStrategyImpl;

    public String workWithEnterList(List<String> enter) {
        StringBuilder str = new StringBuilder();

        for (String enetr : enter) {
            String[] split = enetr.split(",");

            String fruitType = split[1];
            String operation = split[0];
            int amount = Integer.parseInt(split[2]);

            int result = operationsStrategyImpl.operation(operation, fruitType, amount);
            str.append(fruitType).append(",").append(result).append("/n");
        }
        return str.toString();
    }
}
