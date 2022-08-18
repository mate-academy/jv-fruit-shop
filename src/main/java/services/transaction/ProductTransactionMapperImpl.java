package services.transaction;

import java.util.List;
import java.util.stream.Collectors;
import services.transaction.model.ProductTransaction;

public class ProductTransactionMapperImpl implements ProductTransactionMapper {
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<ProductTransaction> getProductTransactions(List<String> lines) {
        return lines
                .stream()
                .skip(1)
                .map(this::getProductTransaction)
                .collect(Collectors.toList());
    }

    private ProductTransaction getProductTransaction(String line) {
        String[] splittedLine = line.split(",");
        return new ProductTransaction(
                ProductTransaction.Operation.getOperation(splittedLine[OPERATION_INDEX]),
                splittedLine[PRODUCT_INDEX],
                Integer.parseInt(splittedLine[QUANTITY_INDEX]));
    }
}
