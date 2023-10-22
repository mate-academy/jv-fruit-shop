package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";
    private final Map<Operation, OperationHandler> strategies;

    public ReportGeneratorServiceImpl(final Map<Operation, OperationHandler> strategies) {
        this.strategies = strategies;
    }

    @Override
    public List<String> generateReport(final FruitDao dao) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new ArrayList<>();
        getBalance(dao).entrySet().stream()
                .forEach((entry) -> {
                    stringBuilder.setLength(0);
                    stringBuilder.append(entry.getKey().getName().toLowerCase())
                            .append(COMMA_SEPARATOR).append(entry.getValue());
                    result.add(stringBuilder.toString());
                });
        result.add(0, REPORT_HEADER);
        return result;
    }

    @Override
    public Map<Fruit, Integer> generateBalance(final FruitDao dao) {
        return getBalance(dao);
    }

    private Map<Fruit, Integer> getBalance(final FruitDao dao) {
        final Set<Map.Entry<Fruit, List<FruitTransaction>>> transactions = dao.getTransactions();
        Map<Fruit, Integer> result = new HashMap<>();
        for (Map.Entry<Fruit, List<FruitTransaction>> entry : transactions) {
            int sum = 0;
            Fruit fruit = entry.getKey();
            for (FruitTransaction transaction : entry.getValue()) {
                sum = strategies.get(transaction.getOperation())
                        .execute(sum, transaction.getQuantity());
            }
            if (sum < 0) {
                throw new RuntimeException(BALANCE_CAN_T_BE_NEGATIVE + fruit.getName());
            }
            result.put(fruit, sum);
        }
        return result;
    }
}
