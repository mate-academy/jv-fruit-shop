package service;

import dao.FruitTransactionDao;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import model.Fruit;
import model.FruitTransaction;

public class ReportServiceCsvImpl implements ReportService {
    private static final Path reportPath = Paths.get("src/main/resources/report.Csv");
    private ActivityStrategy activityStrategy;
    private Map<Fruit, BigDecimal> reportFruitMap;
    private FruitTransactionDao fruitTransactionDao;

    public ReportServiceCsvImpl(ActivityStrategy activityStrategy,
                                FruitTransactionDao fruitTransactionDao) {
        this.activityStrategy = activityStrategy;
        this.fruitTransactionDao = fruitTransactionDao;
        reportFruitMap = new HashMap<>();
    }

    @Override
    public boolean createReport() {
        List<FruitTransaction> fruitTransactions = fruitTransactionDao.getAll();
        try {
            Files.writeString(reportPath, reportGenerator(fruitTransactions));
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file", e);
        }
        return true;
    }

    private String reportGenerator(List<FruitTransaction> fruitTransactions) {
        StringBuilder reportBuilder = new StringBuilder();
        BiConsumer<FruitTransaction, Map<Fruit, BigDecimal>> fruitTransactionConsumer = (f, m) ->
                activityStrategy.getHandler(f.getOperation()).doActivity(m, f);
        fruitTransactions.forEach(f -> fruitTransactionConsumer.accept(f, reportFruitMap));
        reportBuilder.append("fruit,quantity");
        reportFruitMap.forEach((fruit, amount) -> reportBuilder.append(System.lineSeparator())
                .append(fruit.getName()).append(",").append(amount));
        return reportBuilder.toString();
    }
}
