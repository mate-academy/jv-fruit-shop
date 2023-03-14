package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String COMMA = ",";
    private static final int TRANSACTION_TYPE = 0;
    private static final int PRODUCT = 1;
    private static final int COUNT = 2;

    @Override
    public List<FruitTransaction> makeTransaction(List<String> transactions) {
        List<FruitTransaction> transactionsObjs = new ArrayList<>();
        for (String transaction : transactions) {
            String[] splitTransaction = transaction.split(COMMA);
            transactionsObjs.add(
                    new FruitTransaction(FruitTransaction.Operation
                            .getOperation(splitTransaction[TRANSACTION_TYPE]),
                    splitTransaction[PRODUCT],
                    Integer.parseInt(splitTransaction[COUNT])));
        }
        return transactionsObjs;
    }
}
