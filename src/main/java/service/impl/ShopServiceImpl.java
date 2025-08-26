package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitDao;
import service.ShopService;
import storage.Storage;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final FruitDao fruitDao = new FruitDaoImpl();

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<String> rawLines) {
        if (rawLines == null) {
            throw new RuntimeException("Input CSV lines cannot be null");
        }

        Map<String, Integer> fruitStock = new HashMap<>();

        for (String line : rawLines) {
            if (line == null || line.isBlank()) {
                throw new RuntimeException("CSV line cannot be null or blank");
            }

            FruitTransaction fruitTransaction = fruitDao.getFromCsvData(line);
            if (fruitTransaction == null) {
                throw new RuntimeException("Failed to parse line into FruitTransaction: " + line);
            }

            String fruitName = fruitTransaction.getFruit();
            int currentAmount = fruitStock.getOrDefault(fruitName, 0);
            int updatedAmount = operationStrategy.applyOperation(fruitTransaction, currentAmount);
            fruitStock.put(fruitName, updatedAmount);
        }

        Storage.getFruitDbResult().putAll(fruitStock);
    }
}
