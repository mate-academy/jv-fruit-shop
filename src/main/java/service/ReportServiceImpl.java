package service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import model.Fruit;
import model.FruitTransaction;

public class ReportServiceImpl implements ReportService {
    private static final String INFORM_LINE = "fruit,quantity";
    private ActivityStrategy activityStrategy;
    private Map<Fruit, BigDecimal> fruitMap;
    private BiConsumer<FruitTransaction, Map<Fruit, BigDecimal>> fruitTransactionConsumer =
            (t, m) -> activityStrategy.getHandler(t.getOperation()).doActivity(m, t);

    public ReportServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
        fruitMap = new HashMap<>();
    }

    @Override
    public String createReport(List<FruitTransaction> fruitTransactions) {
        StringBuilder reportBuilder = new StringBuilder();
        fruitTransactions.forEach(t -> fruitTransactionConsumer.accept(t, fruitMap));
        reportBuilder.append(INFORM_LINE);
        fruitMap.forEach((fruit, amount) -> reportBuilder.append(System.lineSeparator())
                .append(fruit.getName()).append(",").append(amount));
        return reportBuilder.toString();
    }

}
