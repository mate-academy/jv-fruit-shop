package services.stockservice;

import java.util.List;
import model.TransactionDto;
import services.operations.strategy.OperationsStrategy;
import storage.Stock;

public class StockServiceImpl implements StockService {
    private final OperationsStrategy strategyOperations;

    public StockServiceImpl(OperationsStrategy strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<TransactionDto> storage) {
        for (TransactionDto transaction : storage) {
            if (!Stock.stockStorage.containsKey(transaction.getFruit())) {
                Stock.stockStorage.put(transaction.getFruit(), transaction.getAmount());
            }
            Stock.stockStorage.put(transaction.getFruit(),
                    strategyOperations.getOperation(
                            transaction.getOperationType()).getNewAmount(
                            transaction, Stock.stockStorage.get(transaction.getFruit())));
        }
    }
}
