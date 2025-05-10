package service;

import java.util.ArrayList;
import java.util.List;
import model.Transaction;

public class TransactionParserImpl implements TransactionParser {
    public static final String COMMA = ",";
    public static final int OPERATION_TYPE_INDEX = 0;
    public static final int FRUIT_TYPE_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;
    public static final int OFFSET = 1;

    @Override
    public List<Transaction> parse(List<String> lines) {
        if (lines.size() <= OFFSET) {
            throw new RuntimeException("No operations available in list " + lines);
        }
        List<Transaction> transactions = new ArrayList<>();
        for (int i = OFFSET; i < lines.size(); i++) {
            String[] data = lines.get(i).split(COMMA);
            if (data.length != 3) {
                throw new RuntimeException("Some data isn't available for the record "
                        + lines.get(i));
            }
            Transaction.Operation operation =
                    Transaction.Operation.getOperationByCode(data[OPERATION_TYPE_INDEX]);
            String fruit = data[FRUIT_TYPE_INDEX];
            int amount = Integer.parseInt(data[AMOUNT_INDEX]);
            Transaction transaction = new Transaction(operation, fruit, amount);
            transactions.add(transaction);
        }
        return transactions;
    }
}
