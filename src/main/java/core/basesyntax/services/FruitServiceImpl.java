package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransaction(List<String> transaction) {
        return transaction.stream()
                .map(s -> s.split(","))
                .map(t -> new FruitTransaction(Operation.valueOf(t[OPERATION_INDEX]
                ), t[FRUIT_NAME_INDEX], Integer.parseInt(t[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }

    @Override
    public String createReport(Map<String, Integer> fruits) {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.append(System.lineSeparator()).append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
