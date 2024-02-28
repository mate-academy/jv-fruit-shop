package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParseTransactionService;
import java.util.ArrayList;
import java.util.List;

public class ParseTransactionServiceImpl implements ParseTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransaction(List<String> linesFromFile) {
        List<FruitTransaction> transactionsFromFile = new ArrayList<>();
        String[] transactionDetails;
        for (int i = 1; i < linesFromFile.size(); i++) {
            transactionDetails = linesFromFile.get(i).split(",");
            transactionsFromFile.add(
                    new FruitTransaction(
                            Operation.getOperation(
                                    transactionDetails[OPERATION_INDEX]
                            ),
                            transactionDetails[FRUIT_INDEX],
                            Integer.parseInt(transactionDetails[QUANTITY_INDEX])
                    )
            );
        }
        return transactionsFromFile;
    }
}
