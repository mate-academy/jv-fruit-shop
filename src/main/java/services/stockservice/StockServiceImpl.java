package services.stockservice;

import java.util.HashMap;
import java.util.List;
import model.TransactionDto;
import services.operations.strategy.OperationsStrategy;
import storage.Stock;

public class StockServiceImpl implements StockService {
    private OperationsStrategy strategyOperations;

    public StockServiceImpl(OperationsStrategy strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public Stock getStock(List<TransactionDto> storage) {
        Stock storageReport = new Stock(new HashMap<>());
        for (TransactionDto transaction : storage) {
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
