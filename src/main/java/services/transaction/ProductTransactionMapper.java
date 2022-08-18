package services.transaction;

import java.util.List;
import services.transaction.model.ProductTransaction;

public interface ProductTransactionMapper {
    List<ProductTransaction> getProductTransactions(List<String> lines);
}
