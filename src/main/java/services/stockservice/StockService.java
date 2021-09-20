package services.stockservice;

import storage.Stock;
import storage.StorageTransactions;

public interface StockService {
    Stock getStock(StorageTransactions storageTransactions);
}
