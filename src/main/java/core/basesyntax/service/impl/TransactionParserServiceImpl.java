package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int TRANSACTION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int COUNT = 2;

    @Override
    public List<FruitTransaction> parseToFruitTransaction(List<String> textLines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String textLine : textLines) {
            String[] splitedLines = textLine.split(",");
            transactions.add(
                    new FruitTransaction(FruitTransaction.Operation
                            .getOperation(splitedLines[TRANSACTION_TYPE]),
                            splitedLines[FRUIT_NAME],
                            Integer.parseInt(splitedLines[COUNT])));
        }
        return transactions;
    }
}
