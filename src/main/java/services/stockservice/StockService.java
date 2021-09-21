package services.stockservice;

import java.util.List;
import model.TransactionDto;
import storage.Stock;

public interface StockService {
    Stock getStock(List<TransactionDto> storageTransactions);
}
