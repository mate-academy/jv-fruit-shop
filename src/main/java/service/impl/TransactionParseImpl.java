package service.impl;

import model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;
import service.TransactionParse;

public class TransactionParseImpl implements TransactionParse {
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OF_CODE_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> transactionParse(List<String> data) {
        return data.stream()
                .map(e -> e.split(COMA_SEPARATOR))
                .map(e -> new FruitTransaction(FruitTransaction.Operation
                        .byCode(e[INDEX_OF_CODE_OPERATION]), e[INDEX_OF_FRUIT],
                        Integer.parseInt(e[INDEX_OF_QUANTITY])))
                .collect(Collectors.toList());
    }
}
