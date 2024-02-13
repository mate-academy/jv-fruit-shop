package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseTransactionService;
import java.util.ArrayList;
import java.util.List;

public class ParseTransactionServiceImpl implements ParseTransactionService {
    @Override
    public List<FruitTransaction> parseTransactions(List<String> linesFromFile) {
        List<FruitTransaction> transactionsFromFile = new ArrayList<>();
        String[] transactionDetails;
        for (int i = 1; i < linesFromFile.size(); i++) {
            transactionDetails = linesFromFile.get(i).split(",");
            transactionsFromFile.add(
                    new FruitTransaction(FruitTransaction.Operation.fromCode(transactionDetails[0]),
                            transactionDetails[1],
                            Integer.parseInt(transactionDetails[2]))
            );
        }
        return transactionsFromFile;
    }
}
