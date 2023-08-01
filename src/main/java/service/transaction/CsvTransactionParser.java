package service.transaction;

import java.util.List;
import model.Transaction;

public class CsvTransactionParser implements TransactionParser {
    private static final String VALID_DATA_PATTERN = "^[a-z],[a-zA-Z`]+,\\d+$";
    private static final String SPLIT_SYMBOL = ",";
    private static final int HEAD_INDEX = 0;
    private static final int TYPE_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> data) {
        data.remove(HEAD_INDEX);
        return data.stream()
                .map(String::trim)
                .map(this::transactionFromLine)
                .toList();
    }

    private Transaction transactionFromLine(String data) {
        checkData(data);
        String[] transactionData = data.split(SPLIT_SYMBOL);
        Transaction.Type type = Transaction.Type.byCode(transactionData[TYPE_INDEX]);
        String product = transactionData[PRODUCT_INDEX];
        int quantity = Integer.parseInt(transactionData[QUANTITY_INDEX]);
        return new Transaction(type, product, quantity);
    }

    private void checkData(String data) {
        if (!data.matches(VALID_DATA_PATTERN)) {
            throw new IllegalStateException("Invalid transaction data - " + data);
        }
    }
}
