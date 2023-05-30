package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int SKIP_HEADER = 1;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        return transactions.stream().skip(SKIP_HEADER)
                .map(transaction -> {
                    String[] splitTransaction = transaction.split(SEPARATOR);
                    FruitTransaction.Operation operation = FruitTransaction.Operation
                            .getOperationByCode(splitTransaction[TRANSACTION_INDEX]);
                    String fruit = splitTransaction[FRUIT_INDEX];
                    int quantity = Integer.parseInt(splitTransaction[AMOUNT_INDEX]);
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
