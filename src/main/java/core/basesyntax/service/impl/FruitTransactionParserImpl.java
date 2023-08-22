package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements TransactionParser {

    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> data) {
        return data.stream()
                .map(transactionData -> {
                    String[] transactionFields = transactionData.split(SEPARATOR);
                    if (transactionFields.length != 3) {
                        throw new IllegalArgumentException("Invalid transaction data: "
                                + transactionData);
                    }
                    Operation operation = Operation
                            .returnOperation(transactionFields[OPERATION_INDEX]);

                    String fruit = transactionFields[FRUIT_INDEX];
                    int quantity = Integer.parseInt(transactionFields[QUANTITY_INDEX].trim());
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
