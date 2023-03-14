package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.model.Transaction;
import com.mate.fruitshop.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {

    public static final String DELIMITER = ",";
    public static final int OPERATION_CODE_INDEX = 0;
    public static final int FRUIT_NAME_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String CORRECT_REGEX = "[pbrs],([a-zA-Z ]+),(\\d+)";
    public static final int TABLE_TITLE_INDEX = 0;

    @Override
    public List<Transaction> parse(List<String> lines) {
        if (lines == null || lines.size() < 1) {
            throw new RuntimeException("Empty data list");
        }
        List<Transaction> transactions = new ArrayList<>();
        lines.remove(TABLE_TITLE_INDEX);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (!line.matches(CORRECT_REGEX)) {
                throw new RuntimeException("Incorrect data on line: " + i);
            }
            String[] values = line.split(DELIMITER);
            Transaction.Operation operation =
                    Transaction.Operation.getOperationByCode(values[OPERATION_CODE_INDEX]);
            String fruitName = values[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(values[QUANTITY_INDEX]);
            transactions.add(new Transaction(operation, fruitName, quantity));
        }
        return transactions;
    }
}
