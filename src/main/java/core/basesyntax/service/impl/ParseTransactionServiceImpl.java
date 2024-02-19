package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseTransactionService;
import java.util.ArrayList;
import java.util.List;

public class ParseTransactionServiceImpl implements ParseTransactionService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> linesFromFile) {
        List<FruitTransaction> transactionsFromFile = new ArrayList<>();
        String[] transactionDetails;
        for (int i = 1; i < linesFromFile.size(); i++) {
            transactionDetails = linesFromFile.get(i).split(",");
            transactionsFromFile.add(
                    new FruitTransaction(
                            FruitTransaction.Operation.getOperation(
                                    transactionDetails[INDEX_OF_OPERATION]
                            ),
                            transactionDetails[INDEX_OF_FRUIT],
                            Integer.parseInt(transactionDetails[INDEX_OF_QUANTITY])
                    )
            );
        }
        return transactionsFromFile;
    }
}
