package services.transaction;

import java.util.List;
import java.util.stream.Collectors;
import services.transaction.model.ProductTransaction;

public class UnboxingTransactionImpl implements UnboxingTransaction {
    private static final int TYPE_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<ProductTransaction> unboxing(List<String> allTransactionsString) {
        allTransactionsString.remove(0);
        return allTransactionsString
                .stream()
                .map(this::stringToProductTransaction)
                .collect(Collectors.toList());
    }

    private ProductTransaction stringToProductTransaction(String strTransaction) {
        String[] dataTransaction = strTransaction.split(",");
        return new ProductTransaction(
                ProductTransaction.Operation.getOperation(dataTransaction[TYPE_INDEX]),
                dataTransaction[PRODUCT_INDEX],
                Integer.parseInt(dataTransaction[QUANTITY_INDEX]));
    }
}
