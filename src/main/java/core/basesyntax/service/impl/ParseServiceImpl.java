package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final String WRONG_OPERATION_MESSAGE = "Wrong operation for this store ";
    private static final String SPLIT_TO_LINES_REGEX = "\r\n";
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<Transaction> parse(String data) {
        List<String> rowData = Arrays.stream(data.split(SPLIT_TO_LINES_REGEX))
                .collect(Collectors.toCollection(ArrayList::new));
        rowData.remove(0);
        List<Transaction> transactions = new ArrayList<>();
        createTransactions(rowData, transactions);
        return transactions;
    }

    private void createTransactions(List<String> parsedData, List<Transaction> transactions) {
        for (String line : parsedData) {
            String[] split = line.trim().split(CSV_SEPARATOR);
            Transaction transaction = new Transaction();
            transaction.setOperation(parseOperation(split[OPERATION_INDEX]));
            transaction.setProduct(split[PRODUCT_INDEX]);
            transaction.setValue(Integer.parseInt(split[AMOUNT_INDEX]));
            transactions.add(transaction);
        }
    }

    private Operation parseOperation(String operationType) {
        switch (operationType) {
            case "b":
                return Operation.BALANCE;
            case "s":
                return Operation.SUPPLY;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            default:
                throw new UnsupportedOperationException(WRONG_OPERATION_MESSAGE + operationType);
        }
    }
}
