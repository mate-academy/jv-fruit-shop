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
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<Transaction> parse(String data) {
        List<String> rowData = Arrays.stream(data.split(System.lineSeparator()))
                .collect(Collectors.toCollection(ArrayList::new));
        rowData.remove(0);
        List<Transaction> transactions = new ArrayList<>();
        return buildTransactions(rowData, transactions);
    }

    private List<Transaction> buildTransactions(List<String> parsedData,
                                                List<Transaction> transactions) {
        for (String line : parsedData) {
            String[] split = line.trim().split(CSV_SEPARATOR);
            Transaction transaction = new Transaction();
            transaction.setOperation(determineOperationType(split[OPERATION_INDEX]));
            transaction.setProduct(split[PRODUCT_INDEX]);
            transaction.setValue(Integer.parseInt(split[AMOUNT_INDEX]));
            transactions.add(transaction);
        }
        return transactions;
    }

    private Operation determineOperationType(String operationType) {
        return switch (operationType) {
            case "b" -> Operation.BALANCE;
            case "s" -> Operation.SUPPLY;
            case "p" -> Operation.PURCHASE;
            case "r" -> Operation.RETURN;
            default -> throw new UnsupportedOperationException(WRONG_OPERATION_MESSAGE
                    + operationType);
        };
    }
}
