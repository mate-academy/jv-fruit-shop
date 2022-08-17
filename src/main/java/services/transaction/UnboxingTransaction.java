package services.transaction;

import java.util.List;
import services.transaction.model.ProductTransaction;

public interface UnboxingTransaction {
    List<ProductTransaction> unboxing(List<String> allTransactionString);
}
