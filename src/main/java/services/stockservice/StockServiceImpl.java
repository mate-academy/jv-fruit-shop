package services.stockservice;

import java.util.HashMap;
import model.TransactionDto;
import services.operations.strategy.StrategyOperations;
import storage.Stock;
import storage.StorageTransactions;

public class StockServiceImpl implements StockService {
    private StrategyOperations strategyOperations;

    public StockServiceImpl(StrategyOperations strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public Stock getStock(StorageTransactions storage) {
        Stock storageReport = new Stock(new HashMap<>());
        for (TransactionDto transaction : storage.getStorage()) {
            if (!storageReport.getStockStorage().containsKey(transaction.getFruit())) {
                storageReport.getStockStorage()
                        .put(transaction.getFruit(), transaction.getAmount());
            }
            storageReport.getStockStorage().put(transaction.getFruit(),
                    strategyOperations.getOperation(
                            transaction.getOperationType()).getNewAmount(
                            transaction, storageReport.getStockStorage()
                                    .get(transaction.getFruit())));
        }
        return storageReport;
    }
}
