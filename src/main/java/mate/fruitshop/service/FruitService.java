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
    private FruitTransactionDao dao;

    public FruitService(FruitTransactionDao dao) {
        this.dao = dao;
    }

    public Map<String, Integer> calculateFruitsLeft() {
        List<FruitTransaction> transactions = dao.getAll();
        Map<String, Integer> fruitQuantityMap = new HashMap<>();
        int currentFruitQuantity;

        for (FruitTransaction transaction: transactions) {
            currentFruitQuantity = TRANSACTIONS_MAP.get(transaction.getOperation())
                    .conductTransaction(transaction,
                            fruitQuantityMap.getOrDefault(transaction.getFruit(), 0));
            fruitQuantityMap.put(transaction.getFruit(), currentFruitQuantity);
        }
        return fruitQuantityMap;
    }

    public String createReport(Map<String, Integer> fruitQuantityMap) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(FRUIT + ", " + QUANTITY);
        fruitQuantityMap.entrySet().stream()
                        .forEach(e -> reportBuilder.append(System.lineSeparator())
                                        .append(e.getKey()).append(", ").append(e.getValue()));
        return reportBuilder.toString();
    }

    public void saveReport(String report) {
        dao.saveReport(report);
    }
}
