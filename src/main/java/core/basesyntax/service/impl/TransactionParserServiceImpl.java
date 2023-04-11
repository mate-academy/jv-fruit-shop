package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String LINE_SEPARATOR = ",";
    private static int OPERATION_INDEX = 0;
    private static int FRUIT_INDEX = 1;
    private static int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            String[] splitLine = dataFromFile.get(i).split(LINE_SEPARATOR);
            transactions.add(new FruitTransaction(FruitTransaction.Operation
                    .getOperation(splitLine[OPERATION_INDEX]),
                    splitLine[FRUIT_INDEX],
                    Integer.parseInt(splitLine[QUANTITY_INDEX])));
        }
        return transactions;
    }
}
