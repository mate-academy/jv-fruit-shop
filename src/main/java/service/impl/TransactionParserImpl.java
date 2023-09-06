package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OF_CODE_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> data) {
        try {
            return data.stream()
                    .map(d -> d.split(COMA_SEPARATOR))
                    .map(p -> new FruitTransaction(FruitTransaction.Operation
                            .byCode(p[INDEX_OF_CODE_OPERATION]), p[INDEX_OF_FRUIT],
                            Integer.parseInt(p[INDEX_OF_QUANTITY])))
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            throw new RuntimeException("Invalid value for fruit quantity");
        }
    }
}
