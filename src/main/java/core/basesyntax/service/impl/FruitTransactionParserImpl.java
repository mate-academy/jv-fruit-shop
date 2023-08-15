package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements TransactionParser {

    public static final int NAME_INDEX_OPERATION = 0;
    public static final int NAME_INDEX_FRUIT = 1;
    public static final int NAME_INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> data) {
        return data.stream()
                .map(transactionData -> {
                    String[] transactionFields = transactionData.split(",");
                    if (transactionFields.length != 3) {
                        throw new IllegalArgumentException("Invalid transaction data: "
                                + transactionData);
                    }
                    Operation operation = Operation
                            .returnOperation(transactionFields[NAME_INDEX_OPERATION]);

                    String fruit = transactionFields[NAME_INDEX_FRUIT];
                    int quantity = Integer.parseInt(transactionFields[NAME_INDEX_QUANTITY].trim());
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
