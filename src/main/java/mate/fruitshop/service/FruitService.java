package mate.fruitshop.service;

import static mate.fruitshop.dao.FruitTransactionDaoCsv.FRUIT;
import static mate.fruitshop.dao.FruitTransactionDaoCsv.QUANTITY;
import static mate.fruitshop.service.strategy.TransactionHandlerStrategy.TRANSACTIONS_MAP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mate.fruitshop.dao.FruitTransactionDao;
import mate.fruitshop.model.FruitTransaction;

public class FruitService {
    private final FruitTransactionDao dao;

    public FruitService(FruitTransactionDao dao) {
        this.dao = dao;
    }

    public Map<String, Integer> calculateFruitsLeft() {
        List<FruitTransaction> transactions = dao.getAll();
        Map<String, Integer> fruitQuantityMap = new HashMap<>();
        transactions.forEach(t -> fruitQuantityMap.compute(t.getFruit(), (k, v) ->
                TRANSACTIONS_MAP.get(t.getOperation())
                        .conductTransaction(t, v == null ? 0 : v)));
        return fruitQuantityMap;
    }

    public String createReport(Map<String, Integer> fruitQuantityMap) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(FRUIT + ", " + QUANTITY);
        fruitQuantityMap.forEach((key, value) -> reportBuilder.append(System.lineSeparator())
                .append(key).append(", ").append(value));
        return reportBuilder.toString();
    }

    public void saveReport(String report) {
        dao.saveReport(report);
    }
}
