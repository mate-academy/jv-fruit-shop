package services.stockservice;

import java.util.List;
import model.TransactionDto;

public interface StockService {
    void applyOperationsOnFruitsDto(List<TransactionDto> storageTransactions);
}
