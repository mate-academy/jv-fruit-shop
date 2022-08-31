package homework.service.impl;

import homework.model.Fruit;
import homework.model.FruitTransaction;
import homework.service.ParseTransactionsService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseTransactionsServiceImpl implements ParseTransactionsService {
    public static final String SEPARATOR = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> strings) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] transaction;
        String name;
        int quantity;
        for (int i = 1; i < strings.size(); i++) {
            transaction = strings.get(i).split(SEPARATOR);
            String operationString = transaction[OPERATION_INDEX];
            FruitTransaction.Operation operation
                    = Arrays.stream(FruitTransaction.Operation.values())
                    .filter(v -> v.getOperation().equals(operationString))
                    .findFirst()
                    .orElseThrow(() ->
                            new RuntimeException("Nof find operation " + operationString));
            name = transaction[NAME_INDEX];
            quantity = Integer.parseInt(transaction[AMOUNT_INDEX]);
            transactions.add(new FruitTransaction(operation, new Fruit(name), quantity));
        }
        return transactions;
    }
}
