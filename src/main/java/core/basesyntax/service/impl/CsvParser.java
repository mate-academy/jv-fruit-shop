package core.basesyntax.service.impl;

import core.basesyntax.dto.ProductTransaction;
import core.basesyntax.enums.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.List;

public class CsvParser implements TransactionParser {
    private static final String COMMA = ",";
    private static final int OPERATION_CODE = 0;
    private static final int PRODUCT_NAME = 1;
    private static final int PRODUCT_AMOUNT = 2;

    @Override
    public List<ProductTransaction> parseTransactions(List<String> data) {
        return data.stream().skip(1).map(this::mapToProductTransaction).toList();
    }

    private ProductTransaction mapToProductTransaction(String line) {

        String[] transactionData = line.split(COMMA);
        Operation operation =
                Operation.fromCode(transactionData[OPERATION_CODE]);
        String product = transactionData[PRODUCT_NAME];
        int productAmount = Integer.parseInt(transactionData[PRODUCT_AMOUNT]);
        return new ProductTransaction(operation, product, productAmount);
    }
}
