package services.transaction;

import java.util.List;
import services.transaction.model.ProductTransaction;

public interface TransactionService {
    void processing(List<ProductTransaction> productTransactions);
}
