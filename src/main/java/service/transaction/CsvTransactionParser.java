package service.transaction;

import java.util.List;
import model.FruitTransaction;

public class CsvTransactionParser implements TransactionParser {
    private static final String VALID_DATA_PATTERN = "^[a-z],[a-zA-Z`]+,\\d+$";
    private static final String SPLIT_SYMBOL = ",";
    private static final int HEAD_INDEX = 0;
    private static final int TYPE_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        data.remove(HEAD_INDEX);
        return data.stream()
                .map(String::trim)
                .map(this::transactionFromLine)
                .toList();
    }

    private FruitTransaction transactionFromLine(String data) {
        checkData(data);
        String[] transactionData = data.split(SPLIT_SYMBOL);
        FruitTransaction.OperationType type = FruitTransaction
                .OperationType.byCode(transactionData[TYPE_INDEX]);
        String product = transactionData[PRODUCT_INDEX];
        int quantity = Integer.parseInt(transactionData[QUANTITY_INDEX]);
        return new FruitTransaction(type, product, quantity);
    }

    private void checkData(String data) {
        if (!data.matches(VALID_DATA_PATTERN)) {
            throw new IllegalStateException("Invalid transaction data - " + data);
        }
    }
}
