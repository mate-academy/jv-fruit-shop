package core.basesyntax.services.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.services.ParseDataService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";

    @Override
    public List<Transaction> parse(List<String> data) {
        return data.stream()
                .map(line -> {
                    String[] parts = line.split(DELIMITER);
                    Transaction transaction = new Transaction();
                    transaction.setOperation(Transaction.Operation
                                                .getOperation(parts[OPERATION_TYPE_INDEX]));
                    transaction.setFruit(parts[FRUIT_NAME_INDEX]);
                    transaction.setQuantity(Integer.parseInt(parts[QUANTITY_INDEX]));
                    return transaction;
                })
                .collect(Collectors.toList());
    }
}
