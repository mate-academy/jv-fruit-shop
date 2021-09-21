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
            String operationType = transaction.getOperationType();
            int oldAmount = Stock.stockStorage.get(transaction.getFruit());
            int quantity = strategyOperations
                    .getOperation(operationType).getNewAmount(transaction, oldAmount);
            Stock.stockStorage.put(transaction.getFruit(), quantity);
        }
    }
}
