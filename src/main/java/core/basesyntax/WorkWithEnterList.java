package core.basesyntax;

import java.util.List;

public class WorkWithEnterList {
    public WorkWithEnterList(OperationsStrategy operationsStrategy) {
        this.operationsStrategy = operationsStrategy;
    }

    private OperationsStrategy operationsStrategy;


    public String workWithEnterList(List<String> entery) {
        StringBuilder str = new StringBuilder();

        for (String enetr : entery) {
            String[] split = enetr.split(",");

            String fruitType = split[1];
            String operation = split[0];
            int amount = Integer.parseInt(split[2]);

            int result = operationsStrategy.operation(operation, fruitType, amount);
            str.append(fruitType).append(",").append(result).append("/n");
        }
        return str.toString();
    }
}
